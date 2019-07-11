
<template>
    <div id="box">
       <div class="row" v-for="(item,index) in dataList">
           <!--使用mint-ui的switch组件-->
           <mt-switch v-model="value[index]" class="switch"></mt-switch>
           <img :src="item.thumb_path" alt="商品图片" class="img">
           <div class="carRight">
               <h4 v-text="item.title"></h4>
               <div class="bottom">
                   <ul>
                       <li>￥{{item.sell_price}}</li>
                       <!--导入设置数量的组件-->
                       <li>
                           <!--购买的数量-->
                           <shopCarNum :initCount="item.cou" :goodsId="item.id" v-on:carResObj="getCarResObj"></shopCarNum>
                       </li>
                       <li><a href="javascript:void(0)" @click="deleteCar(item.id,index)">删除</a></li>
                   </ul>
               </div>
           </div>
       </div>

        <div id="total">
            <div class="desc">
                <ul>
                    <li>总计（不含运费）:</li>
                    <li>已勾选商品 <strong>{{totalCount}}</strong> 件，总计: <strong>￥{{totalAmount}}元</strong></li>
                </ul>
                <div id="button">
                    <mt-button type="danger" size="small">去结算</mt-button>
                </div>
            </div>
        </div>
    </div>

</template>
<script>
    /*导入存储工具中的获取商品的函数*/
    import {getGoodsObj} from '../../kit/localStor';
    /*导入存储工具中的更新商品的函数*/
    import {updateData} from '../../kit/localStor';
    /*导入存储工具中的删除商品的函数*/
    import {removeItem} from '../../kit/localStor';

    import {api} from '../../kit/common';
    import { Toast } from 'mint-ui';

    /*导入组件*/
    import shopCarNum from '../subcom/shopCarNum.vue';

    export default{
        components:{
            shopCarNum
        },
        data(){
            return{
                dataList:[
//                    {
//                        "cou":1,
//                        "id":"59f176fce370ed17f00305d1",
//                        "title":"华为（HUAWEI）荣耀6Plus 16G双4G版",
//                        "sell_price":5888,
//                        "thumb_path":"http://wxtest.centaline.com.cn/api/upload/goods/design_glass_small_2x.jpg"
//                    },
//                    {
//                        "cou":1,
//                        "id":"59f176fce370ed17f00305d1",
//                        "title":"华为（HUAWEI）荣耀6Plus 16G双4G版",
//                        "sell_price":5888,
//                        "thumb_path":"http://wxtest.centaline.com.cn/api/upload/goods/design_glass_small_2x.jpg"
//                    }


                ],
                value:[],
                totalAmount:0
            }
        },
        created(){
            /*调用方法获取购物车列表数据*/
            this.getDataList();
        },
        methods:{
            /*动态获取数据*/
            getDataList(){
                /* 从localStorage中获取到所有商品的id*/
                var obj = getGoodsObj();
//                console.log(obj);

                /*将id值按照api的参数格式提交给api*/
                var idString = '';
                for(var key in obj){
                    idString += key + ',';
                }

                /*删除最后一个逗号*/
                idString = idString.substring(0,idString.length - 1);
//                console.log(idString);

                /*ajax请求这个api获取到完整的商品数据信息赋值给this.dataList*/
                /*http://wxtest.centaline.com.cn/api/api?type=getshopcarlist&ids=59f176fce370ed17f00305d1,59f176fce370ed17f00305d3*/

                var url = api + 'type=getshopcarlist&ids='+idString;
//                console.log(url);

                this.$http.get(url).then(function (response) {
                    if (response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    /*将localStorage中所有的商品对应的count值赋值给message中每个对象的cou*/
                    response.body.message.forEach(function (item) {
                        item.cou = obj[item.id];
//                        this.value.push(false);
                        /*为了解决一个bug所以必须在此处初始化values数组全部为false*/
                    });

                    this.dataList = response.body.message;
                })

            },

            /*获取子组件中的数据*/
            getCarResObj(resObj){
                /*更新localStorage中的数据*/
                updateData(resObj);
                /*更新this.dataList中的当前数量*/
                for (var i = 0; i < this.dataList.length; i++) {
                    /*根据id匹配是点击了哪类商品*/
                  if(this.dataList[i].id == resObj.goodsId){
                      if(resObj.type == 'increaseNumFun'){
                          this.dataList[i].cou = this.dataList[i].cou + 1;
                      }else {
                          this.dataList[i].cou = this.dataList[i].cou - 1;
                      }
                      break;
                  }

                }
            },

            /*删除商品*/
            deleteCar(goodsId,index){
                console.log(goodsId, index);
                /*将this.value数组中的index这个位置的值移除（会自动触发计算属性totalcount）*/
                this.value.splice(index,1);
                /*将this.dataList中的index这个位置的值移除（会自动触发计算属性totalcount）*/
                this.dataList.splice(index,1);
                /*删除本地存储中的goodsId对应的所有值*/
                removeItem(goodsId);
            }
        },
        /*定义计算总件数的属性*/
        computed:{
            totalCount(){
                /*计算逻辑：只需要计算出this.value数组中的true值有多少个即可*/
                var trueArr = this.value.filter(function (item) {
                    return item;
                });
                /*计算方式：当前商品的购买数量*商品的单价*/
                var amount = 0;
                this.value.forEach((item,index) =>{
                    /*当前的item如果为TRUE，则这个商品的总价格是要计算的*/
                    if(item){
                        var count = this.dataList[index].cou;
                        var price = this.dataList[index].sell_price;
                        var itemAmount = count * price;
                        amount += itemAmount;
                    }
                });
                this.totalAmount = amount;
                return trueArr.length;
            }

        }

    }
</script>
<style>
    .row{
        border-bottom:1px solid rgba(0,0,0,0.3);
        height: 102px;
        display: flex;
        padding: 15px 5px 5px 5px;
    }
    .switch{
        flex:0 0 52px;
    }
    .img{
        width: 75px;
        height: 75px;
        margin-left: 5px;
        flex: 0 0 85px;
    }
    .carRight{
        margin-left: 8px;
        flex:1;
    }
    .carRight ul{
        margin-top: 5px;
        padding-left: 0;
        /*background-color: red;*/
    }
    .carRight li{
        list-style: none;
        display: inline-block;
    }
    .carRight h4{
        color:#0094ff;
        font-size: 14px;
        line-height: 20px;
    }
    .bottom li:first-child{
        color: red;
        margin-right: 5px;
    }
    .bottom li:last-child{
        margin-left: 5px;
    }
    .bottom li:first-child{
        color:red;
        margin-right: 5px;
    }
    .bottom li:last-child{
        margin-left: 5px;
    }

    #total{
        height: 80px;
        background-color: rgba(0,0,0,0.1);
        display: flex;
        padding: 5px;
        line-height: 25px;
        flex-direction: row;
        align-items: center;

    }
    #button{
        flex:0 0 60px;
        margin: 25px 0 0 0;
    }
    .desc{
        display: flex;
    }
    #total ul{
        flex: 5;
        padding-left: 20px;
        padding-right: 40px;
    }
    #total li{
        list-style: none;
        font-size: 14px;
    }


</style>

