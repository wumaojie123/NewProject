<template>
    <div id="box">
        <div id="mui-content" style="background-color:#fff">
            <ul class="mui-table-view mui-grid-view">
                <li class="mui-table-view-cell mui-media mui-col-xs-6" v-for="(item,index) in goodList">
                    <router-link v-bind="{to:'/goods/goodInfo/'+item.id}">
                        <img class="mui-media-object" :src="item.img_url">
                        <h4 class="mui-media-body">
                            {{item.title}}
                        </h4>
                        <div class="des">
                            <p>
                                <span>￥{{item.sell_price}}</span>
                                <s>￥{{item.market_price}}</s>
                            </p>
                            <p>
                                <span class="left">热卖中</span>
                                <span class="right">剩余{{item.stock_quantity}}件</span>
                            </p>
                        </div>
                    </router-link>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    import {api} from '../../kit/common';
    import { Toast } from 'mint-ui';


    export default{

        data(){
            return{
                goodList:[
                    /*{
                        "id":"59f176fce370ed17f00305d1",
                        "title":"华为（HUAWEI）荣耀6Plus 16G双4G版",
                        "add_time":"2017-10-26 13:47:39",
                        "zhaiyao":"美在智慧",
                        "click":122,
                        "img_url":"http://wxtest.centaline.com.cn/api/upload/goods/design_glass_small_2x.jpg",
                        "sell_price":5888,
                        "market_price":7188,
                        "stock_quantity":199,
                        "pagecount":2
                    },
                    {"id":"59f176fce370ed17f00305d3","title":"华为（HUAWEI）荣耀6Plus 16G双4G版","add_time":"2017-10-23 13:47:39","zhaiyao":"Apple iPhone 7 (A1660) 32G 银色 移动联通电信4G手机","click":123,"img_url":"http://wxtest.centaline.com.cn/api/upload/goods/57d0c468N85c77866.jpg","sell_price":4588,"market_price":6788,"stock_quantity":98,"pagecount":2},*/
                ]
            }
        },
        created(){
            this.getGoodList();
        },
        methods:{
            getGoodList(){
                /*
                 http://wxtest.centaline.com.cn/api/api?type=getgoods&pageindex=1
                 */
                var url = api + 'type=getgoods&pageindex=0';
                this.$http.get(url).then(function (response) {
                    if (response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    this.goodList = response.body.message;
                })
            }
        }

    }
</script>

<style scoped>
    #mui-content li{
        border: 1px solid rgba(0, 0, 0, 0.1);
        -webkit-box-shadow: 0 0 1px #000;
        -moz-box-shadow: 0 0 1px #000;
        box-shadow: 0 0 1px #000;
        margin-left: 4px;
        padding: 6px;
    }
    #mui-content .mui-media-body{
        color: #0094ff;
    }
    #mui-content .des{
        height: 60px;
        background-color: rgba(0,0,0,0.1);
        margin-top: 10px;
        padding: 5px;
        text-align: left;
        margin-left: 3px;
    }
    #mui-content .des span{
        color:red;
        margin-right: 15px;
    }
    #mui-content a{
        padding-left: 0;
        margin-left: 0;
    }
    #mui-content .des .right{
        position: absolute;
        right: 4px;
        bottom: 13px;
        color:rgba(0,0,0,0.5);
    }
    #mui-content .des .left{
        position: absolute;
        left: 14px;
        bottom: 13px;
        color:rgba(0,0,0,0.5);
    }
</style>

