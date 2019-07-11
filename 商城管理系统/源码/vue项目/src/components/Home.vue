<template>
    <div id="box">

        <!--使用第三方组件mint-ui,实现轮播图的效果-->
        <!--<mt-swipe :auto="4000" class="homeSpire">-->
            <!--<mt-swipe-item  v-for="item in list">-->
                <!--<img :src="item.src">-->
            <!--</mt-swipe-item>-->
        <!--</mt-swipe>-->

        <!--子组件显示的区域-->
        <!--传递数据给子组件-->
        <slider :imgs="list"></slider>

        <!--使用第三方组件mui，实现九宫格的效果-->
        <div class="mui-content">
            <ul class="mui-table-view mui-grid-view mui-grid-9">
                <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
                    <router-link to="/news/newList">
                    <span class="mui-icon mui-icon-home"></span>
                    <div class="mui-media-body">新闻资讯</div>
                    </router-link>
                </li>
                <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
                    <router-link to="/photo/photoList">
                    <span class="mui-icon mui-icon-email"></span>
                    <div class="mui-media-body">图片共享</div>
                    </router-link>
                </li>
                <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
                    <router-link to="/goods/goodList">
                    <span class="mui-icon mui-icon-chatbubble"></span>
                    <div class="mui-media-body">商品购买</div>
                    </router-link>
                </li>
                <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
                    <router-link to="/feedback">
                    <span class="mui-icon mui-icon-location"></span>
                    <div class="mui-media-body">留言反馈</div>
                    </router-link>
                </li>
                <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
                    <router-link to="/video">
                    <span class="mui-icon mui-icon-search"></span>
                    <div class="mui-media-body">视频专区</div>
                    </router-link>
                </li>
                <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
                    <router-link to="/callMe">
                    <span class="mui-icon mui-icon-phone"></span>
                    <div class="mui-media-body">联系我们</div></router-link>
                </li>
            </ul>
        </div>

    </div>
</template>

<script>
    /*导入第三方组件的Toast组件*/
    import { Toast } from 'mint-ui';
    import {api} from '../kit/common.js';

    /*导入子组件*/
    import slider from './subcom/slider.vue';

    export default{
        /*使用组件*/
        components:{
            slider
        },
        data(){
            return{
                list:[
//                    {"src":"http://wxtest.centaline.com.cn/api/upload/images/1494957.jpg"},
//                    {"src":"http://wxtest.centaline.com.cn/api/upload/images/1494955.jpg"},
//                    {"src":"http://wxtest.centaline.com.cn/api/upload/images/1494954.jpg"}
                ]
            }
        },
        created(){
            /*当页面中的data和methods对象都创建完毕之后，就会自动调用created*/
            this.getList();
        },
        methods:{
            /*实现轮播图的数据请求*/
            getList(){
//                var url = 'http://wxtest.centaline.com.cn/api/api?type=getslider';
                var url = api+'type=getslider';
                this.$http.get(url).then(function (response) {
                    if (response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    this.list = response.body.message;
                })
            }

        }
    }
</script>
<style scoped>

    /*九宫格的样式*/
    .mui-content{
        background-color: #fff;
    }
    .mui-table-view.mui-grid-view.mui-grid-9{
        background-color: #fff;
        border: none;
    }
    .mui-table-view.mui-grid-view.mui-grid-9>li{
        border: none;
    }
    .mui-icon-home:before,
    .mui-icon-email:before,
    .mui-icon-chatbubble:before,
    .mui-icon-location:before,
    .mui-icon-search:before,
    .mui-icon-phone:before{
        content:'';
        width: 50px;
        height: 50px;
        display: inline-block;
        background-size: contain;
    }
    .mui-icon-home:before{
        background-image: url("../../statics/imgs/1.png");
    }
    .mui-icon-email:before{
        background-image: url("../../statics/imgs/2.png");
    }
    .mui-icon-chatbubble:before{
        background-image: url("../../statics/imgs/4.png");
    }
    .mui-icon-location:before{
        background-image: url("../../statics/imgs/6.png");
    }
    .mui-icon-search:before{
        background-image: url("../../statics/imgs/5.png");
    }
    .mui-icon-phone:before{
        background-image: url("../../statics/imgs/3.png");
    }


    /*轮播图的样式*/
    .homeSpire.mint-swipe{
        width: 100%;
        height: 250px;
        /*background-color: red;*/
    }
    .homeSpire .mint-swipe-items-wrap{
        width: 100%;
        height: 250px;
    }
    .homeSpire .mint-swipe-item{
        height: 250px;
        /*background-color: red;*/
    }
    .homeSpire .mint-swipe-item img{
        height: 250px;
        width: 100%;
    }
    .homeSpire .mint-swipe-indicator{
        background-color: yellow;
        opacity: 1;
        border: 5px solid red;
    }
    .homeSpire .mint-swipe-indicator{
        background-color: red;
        opacity: 1;
    }
    .homeSpire .mint-swipe-indicator.is-active{
        background: #02C1ED;
        opacity: 1;
    }
    div.mint-swipe-indicators{
        background-color: yellow;
    }
    .homeSpire>div:nth-child(1){
        background-color: red;
        border: 1px solid #000;
    }
    .homeSpire>div:nth-child(2).mint-swipe-indicators{
        background-color: red;
        border: 1px solid #000;
    }

</style>

