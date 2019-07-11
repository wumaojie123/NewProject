<template>
    <div id="box">
        <div id="pInfo">
            <!--标题区域-->
            <h4 v-text="photoInfo.title"></h4>
            <!--时间区域-->
            <p class="infoP">
                <span style="margin-right: 10px">{{photoInfo.add_time | datefmt('YYYY-MM-DD')}}</span>
                {{photoInfo.click}}次浏览
            </p>
            <p class="lineP"></p>
            <!--图片展示区域-->
              <!--九宫格显示-->
            <div class="mui-content">
                <ul class="mui-table-view mui-grid-view mui-grid-9 photoUl">
                    <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3" v-for="(item, index) in list">
                        <img class="preview-img"  :src="item.src" height="100" @click="$preview.open(index, list)">
                    </li>


                </ul>
            </div>
             <!--文字描述区域-->
            <p class="content" v-html="photoInfo.content"></p>
        </div>

        <!--子组件显示的区域-->
        <comment :id="id"></comment>
    </div>
</template>

<script>
    import {api} from '../../kit/common';
    import { Toast } from 'mint-ui';

    /*导入评论组件*/
    import comment from '../subcom/comment.vue';

    export default{
        /*子组件的设置*/
        components:{
            comment
        },
       data(){
           return{
               /*初始化id*/
               id:0,
               photoInfo: {
//                   "id":"59f287d5e370ed0d3cc16a5d",
//                   "title":"余承东逛小米之家/苹果全家齐刘海",
//                   "click":772,
//                   "add_time":"2017-10-27 09:11:48",
//                   "content":"十一期间，小米在全国不同城市同时开了N多家小米之家旗舰店。9月底开业的位于深圳华润城万象天地的这家小米之家，之前我们就有报道过。采用全新设计，从造型到服务，堪称目前小米之家中的顶级配备。近日，有网友爆料，华为终端CEO余承东到访了这家小米之家，并与店员攀谈，究竟余总是来考察探访的，还是来购物的？引起网友的热议。"
               },
               list: [
                  /* {
                       src: 'http://wxtest.centaline.com.cn/api/upload/images/1495044.jpg',
                       w: 600,
                       h: 400
                   },
                   {
                       src: 'https://placekitten.com/1200/900',
                       w: 1200,
                       h: 900
                   }*/
               ]
           }
       },
        created(){
            /*接受路由的参数*/
            this.id = this.$route.params.id;
            this.getPhotoInfo();
            this.getList();
        },
        methods:{
            getPhotoInfo(){
                /*http://wxtest.centaline.com.cn/api/api?type=getimageInfo&imgid=59f287d5e370ed0d3cc16a5d*/
                var url = api + 'type=getimageInfo&imgid='+this.id;
                this.$http.get(url).then(function (response) {
                    if(response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    this.photoInfo = response.body.message[0];
                })
            },
            getList(){
                /*http://wxtest.centaline.com.cn/api/api?type=getthumimages&imgid=59f287d5e370ed0d3cc16a5d*/
                var url = api + 'type=getthumimages&imgid='+this.id;
                this.$http.get(url).then(function (response) {
                    if(response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    /*通过遍历数组，添加对象*/
                    response.body.message.forEach(function (item) {
                        var img = document.createElement('img');
                        img.src = item.src;
                        item.w = img.width;
                        item.h = img.height;
                    });
                    this.list = response.body.message;
                })
            }
        }
    }
</script>

<style scoped>
    #pInfo
    {
        padding: 10px 8px 5px;
    }
    #pInfo h4{
        color: #26a2ff;
    }
    #pInfo .infoP{
        color:rgba(0,0,0,0.4);
        padding-top: 5px;
        margin-bottom: 13px;
        font-size: 14px;
    }
    #pInfo p.lineP{
        width: 100%;
        border-bottom:1px solid rgba(0,0,0,0.4);
        margin: 10px 0;
        font-size: 0;
        line-height: 21px;
        box-sizing: border-box;
    }
    #pInfo .content{
        padding: 0 5px;
        font-size: 16px;
        line-height: 25px;
        text-indent: 32px;
        color: black;
    }
    #pInfo .mui-content{
        background-color: #fff;
        /*margin-right: -10px;*/
        /*background-color: red;*/
    }
    #pInfo .photoUl{
        /*background: red;*/
        margin-left: -10px;
    }
    .mui-table-view.mui-grid-view.mui-grid-9{
        background-color: #fff;
        border: none;
    }
    .mui-table-view.mui-grid-view.mui-grid-9>li{
        border: none;
    }
    .mui-content img{
        width: 100px;
        height: 100px;
        /*width: 110px;*/
        /*height: 100px;*/
    }

</style>
