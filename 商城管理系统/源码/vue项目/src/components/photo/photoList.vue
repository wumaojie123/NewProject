<template>
    <div id="box">
        <div id="cate">
            <!--头部选项-->
            <ul class="ulPhoto" v-bind="{style:'width:'+ulWidth+'px'}">
                <li @click="getLazyImageList(0)">全部</li>
                <li v-for="(item,index) in ulPhotoList" @click="getLazyImageList(item.id)">{{item.title}}</li>
            </ul>
        </div>


        <!--使用mint-ui进行图片懒加载-->
        <div>
            <ul class="lazyLoad">
                <li v-for="item in lazyImageList">
                    <router-link v-bind="{to:'/photo/photoInfo/'+item.id}">
                    <img v-lazy="item.img_url">
                    <div class="lazyLoadBox">
                        <h5 v-text="item.title"></h5>
                        <p v-text="item.zhaiyao"></p>
                    </div>
                </router-link>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
    import {api} from '../../kit/common.js';
    import { Toast } from 'mint-ui';
    /*图片懒加载*/
    import { Lazyload } from 'mint-ui';


    export default{
        data(){
            return{
                ulWidth:380,
                ulPhotoList:[],
                lazyImageList:[
//                    {
//                        "id":"59f287d5e370ed0d3cc16a5d",
//                        "title":"余承东逛小米之家/苹果全家齐刘海",
//                        "img_url":"http://wxtest.centaline.com.cn/api/upload/images/1495044.jpg",
//                        "zhaiyao":"iPhone X就要正式开始抢购了。你准备好了吗？"
//                    },
                ]
            }
        },
        created(){
            this.getUlPhotoList();
            var allImage = 0;
            this.getLazyImageList(allImage);
        },
        methods:{
            /*得到分类头的数据*/
            getUlPhotoList(){
                /* http://wxtest.centaline.com.cn/api/api?type=getimages&cateid=59f16e59e370ef14806264df*/
                var url = api+'type=getimgcategory';
                this.$http.get(url).then(function (response) {
                    if(response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    this.ulPhotoList = response.body.message;

                    /*实现当前标题所有ul的宽度*/
                    var w = 90;
                    var count = response.body.message.length + 1;
                    this.ulWidth = w * count;

                })
            },

            /*懒加载图片的数据*/
            getLazyImageList(type){
                /*http://wxtest.centaline.com.cn/api/api?type=getimages&cateid=59f16e59e370ef14806264df*/
                var url = api+'type=getimages&cateid='+type;
                this.$http.get(url).then(function (response) {
                    if(response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    this.lazyImageList = response.body.message;
                })
            }


        }

    }
</script>

<style scoped>
    /*头部选项*/
    #cate{
        width: 372px;
        max-width: 372px;
        overflow-x: auto;
    }
    .ulPhoto{
        /*width: 1000px;*/
        padding: 8px 10px;
        margin-bottom: 5px;
        margin-top: 0;
    }
    .ulPhoto li{
        color: white;
        display: inline-block;
        list-style: none;
        background: #55d9ed;
        /*float: left;*/
        margin-right: 4px;
        /*border: 1px solid #55d9ed;*/
        padding:5px 9px;
        border-radius: 10px;
        font-weight: 600;
    }
    /*懒加载的数据*/
    image[lazy=loading] {
        width: 40px;
        height: 300px;
        margin: auto;

    }
    .lazyLoad{
        margin-top: 0;
        padding: 5px 0;
    }
    .lazyLoad img{
        width: 100%;
        /*height: 100%;*/
        height: 350px;
        /*border: 1px solid #55d9ed;*/
        border-radius: 10px;
    }
    .lazyLoad li{
        position: relative;
        margin-bottom: 2px;
    }
    .lazyLoadBox{
        position: absolute;
        left: 0;
        bottom: 2px;
        color: #fff;
        border-radius: 10px;
        width: 100%;
        background-color: rgba(0,0,0,0.4);
        padding: 3px;
    }
    .lazyLoadBox h5{
        font-size: 15px;
        font-weight: 600;
        color: #55d9ed;
        margin-top: 5px;
        /*color: white;*/
        margin-bottom: 5px;
    }
    .lazyLoadBox p{
        margin-bottom: 5px;
        text-indent: 32px;
        color: #fff;
        font-size: 14px;
    }
</style>
