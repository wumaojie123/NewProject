<template>
    <div id="box">
       <!--1.商品轮播图-->
       <!-- <mt-swipe :auto="4000" class="swipeGood">
            <mt-swipe-item>{{id}}</mt-swipe-item>
            <mt-swipe-item>2</mt-swipe-item>
            <mt-swipe-item>3</mt-swipe-item>
            <mt-swipe-item>3</mt-swipe-item>
        </mt-swipe>-->

        <!--子组件显示的区域-->
        <!--并传递参数给子组件-->
        <div class="sliderImage">
            <slider :imgs="img"></slider>
        </div>

        <!--2.实现商品购买区域-->
        <div id="buy">
            <h4 v-html="dataList.title"></h4>
            <p class="line"></p>
            <ul>
                <li class="price">
                    市场价：<s style="margin-right: 20px;">￥{{dataList.market_price}}</s>
                    销售价：<span>￥{{dataList.sell_price}}</span>
                </li>
                <li class="inputLi">
                    购买数量：
                    <clickNum class="inputNum" v-on:dataObj="getCount"></clickNum>

                    <transition name="show" @before-enter="beforeEnter" @enter="Enter" @after-enter="afterEnter">
                        <div class="ball" v-if="isShow"></div>
                    </transition>

                </li>
                <li>
                    <mt-button type="primary">立即购买</mt-button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                    <mt-button type="danger" @click="GoCar">加入购物车</mt-button>
                </li>
            </ul>
        </div>
        <!--3.图文详解-->
        <div id="params">
            <h6>商品参数</h6>
            <p class="line"></p>
            <ul>
                <li>商品货号：{{dataList.goods_no}}</li>
                <li>库存情况：{{dataList.stock_quantity}}</li>
                <li>上架时间：{{dataList.add_time | datefmt('YYYY-MM-DD')}}</li>
            </ul>
        </div>
        <!--4.商品评论-->
        <div id="other">
            <router-link v-bind="{to:'/goods/goodDesc/'+ dataList.id}">
                <mt-button type="primary" size="large" class="imgdesc">图文详情</mt-button>
            </router-link>

            <router-link v-bind="{to:'/goods/goodComment/'+dataList.id}">
                <mt-button type="danger" size="large">商品评论</mt-button>
            </router-link>

        </div>

    </div>
</template>

<script>
    import {api} from '../../kit/common';
    import { Toast } from 'mint-ui';

    /*导入子组件*/
    import slider from '../subcom/slider.vue';
    import clickNum from '../subcom/clickNum.vue';

    /*使用vm对象和常量值*/
    import {vm,COUNT} from '../../kit/vm.js';
    /*导入函数和值*/
    import {setItem,valueObj} from '../../kit/localStor';

    export default{
        /*使用子组件*/
        components: {
            slider,
            clickNum
        }
        ,
        created(){
            /*获取参数id*/
            this.id = this.$route.params.id;
            /*得到轮播图的数据*/
            this.getGoodImageList();
            this.getDataList();
        },
        data(){
            return{
                id:'',
                img:[
//                    {"src":"http://wxtest.centaline.com.cn/api/upload/images/1494957.jpg"},
//                    {"src":"http://wxtest.centaline.com.cn/api/upload/images/1494955.jpg"},
//                    {"src":"http://wxtest.centaline.com.cn/api/upload/images/1494954.jpg"},
//                    {"src":"http://wxtest.centaline.com.cn/api/upload/images/1494954.jpg"},
                ],
                dataList: {
//                    "id":"59f176fce370ed17f00305d1",
//                    "title":"华为（HUAWEI）荣耀6Plus 16G双4G版",
//                    "add_time":"2017-10-26 13:47:39",
//                    "goods_no":"SDdduejmksdjd",
//                    "stock_quantity":199,
//                    "market_price":7188,
//                    "sell_price":5888
                },
                /*当前购买的数量*/
                inputNum:0,
                /*控制小球的状态*/
                isShow:false
            }
        },
        methods:{
            getGoodImageList(){
                /*http://wxtest.centaline.com.cn/api/api?type=getthumimages&imgid=59f287d5e370ed0d3cc16a5d*/
                var url = api + 'type=getthumimages&imgid=59f287d5e370ed0d3cc16a5d';
                this.$http.get(url).then(function (response) {
                    if (response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    this.img = response.body.message;
                })
            },

            /*获取组件中传入的值，即数量*/
            getCount(count){
                this.inputNum = count;
            },
            getDataList(){
                /*http://wxtest.centaline.com.cn/api/api?type=getinfo&id=59f176fce370ed17f00305d1*/
                var url = api + 'type=getinfo&id='+this.id;
                this.$http.get(url).then(function (response) {
                        if (response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    this.dataList = response.body.message;
                })
            },

            /*触发加入购物车事件，将数值传递出去*/
            /*传递给App.vue*/
            GoCar(){
                /*发送数据*/
                vm.$emit(COUNT,this.inputNum);
                /*将数据保存到localStorage中*/
                console.log(this.id);
                valueObj.goodsId = this.id;
                valueObj.count = this.inputNum;
                setItem(valueObj);
                /*实现小球的显示和隐藏*/
                this.isShow = !this.isShow;
            },

            /*传入三个动画*/
            beforeEnter(el){
                /*设置小球的初始位置*/
                el.style.transform = "translate(0,0)"
            },
            Enter(el,done){
                /*保证小球出现动画*/
                /*刷新位置，动画才会出来*/
                el.offsetWidth;

                /*设置小球的结束位置*/
                el.style.transform = "translate(80px,202px)";

                /*结束动画*/
                /*一定要调用，不然动画结束会很慢*/
                done();
            },
            afterEnter(el){
                /*重置小球的初始状态*/
                /*因为只做了一半*/
                this.isShow = !this.isShow;
            }


        }

    }
</script>

<style scoped>
    .sliderImage,#buy,#params,#other{
        border: 1px solid rgba(0,0,0,0.4);
        border-radius: 5px;
        margin: 5px;
        padding: 5px;
    }
    .sliderImage{
        padding: 0;
    }
    #box .line{
        height: 1px;
        border: 1px solid rgba(0, 0, 0, 0.2);
    }
    #buy ul,#params ul{
        padding-left:0;
    }
    #buy h4{
        color: #0094ff;
        padding: 5px;
        margin-top: 10px;
    }
    #params h6{
        font-size: 14px;
        margin: 10px 0;
    }
    #buy li,#params li{
        list-style: none;
        padding: 8px;
    }
    #buy .price span{
        color: red;
    }
    #other .imgdesc{
        margin-bottom: 5px;
        margin-top: 5px;
    }
    .inputNum{
        display: inline-block;
    }
    .inputLi{
        position: relative;
    }
    .ball{
        width: 20px;
        height: 20px;
        border-radius: 20px;
        background-color: red;
        position: absolute;
        left: 150px;
        top: 10px;
        transition: all 0.4s ease;
        z-index: 998;
    }
</style>
