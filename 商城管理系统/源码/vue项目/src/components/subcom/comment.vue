<template>
    <div>
        <!--1.实现提交评论数据都服务器的静态结构-->
        <div class="postComment">
            <h3>提交评论</h3>
            <p class="lineP"></p>
            <textarea placeholder="请输入您要评论的内容..." v-model="postContent"></textarea>
            <mt-button type="primary" size="large" @click="postComment">发表</mt-button>
        </div>

        <div class="postComment">
            <h3>评论列表</h3>
            <p class="lineP"></p>
            <ul class="mui-table-view">
                <li class="mui-table-view-cell mui-media" v-for="(item,index) in commentList">
                    <a href="javascript:;">
                        <div class="mui-media-body">
                            <img class="mui-media-object mui-pull-left" :src='item.user_logo'>
                            <span>第{{index+1}}楼</span>
                            <span>{{item.user_name}}</span>
                            <span>{{item.add_time | datefmt('YYYY-MM-DD')}}</span>
                            </div>
                            <p class='mui-ellipsis' v-text="item.content"></p>
                    </a>
                </li>

            </ul>
        </div>
        <mt-button type="primary" size="large" plain @click="getMoreComment">加载更多</mt-button>
    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    import {api} from '../../kit/common.js';
    export default{
        /*接受父组件传递过来的id值*/
        props:['id'],
        data(){
            return{
                /*用来自动获取用户填写的评论内容*/
                pageIndex:1,
                postContent:'',
                commentList:[
                   /* {
                        "user_name":"匿名用户",
                        "user_logo":"http://wxtest.centaline.com.cn/haixinfang/images/ic_header_big.png",
                        "add_time":"2017-10-27 13:23:41",
                        "content":"看看是啥","pagecount":2
                    }*/
                ]
            }
        },
        created(){
            this.getComments(this.pageIndex);
        },
        methods:{
            /*加载更多*/
            getMoreComment(){
                this.pageIndex++;
                this.getComments(this.pageIndex);
            },

            /*获取评论的数据*/
            getComments(page){

               /* var url = "http://wxtest.centaline.com.cn/api/api?type=getcomments&artid=59f179e5e370ee17f05af22d&pageindex=1"*/

               var url = api+'type=getcomments&artid='+this.id+'&pageindex='+page;
               this.$http.get(url).then(function (response) {
                   if (response.body.status != 0){
                       Toast(response.body.message);
                       return;
                   }
                   console.log(response.body);
                   this.commentList = this.commentList.concat(response.body.message);

                   /*服务器无更多的数据的时候，吐司提示*/
                   if (response.body.message.length == 0){
                       Toast('没有更多的数据可以加载哦！');
                   }
               })
            },

            /*评论数据的提交*/
            postComment(){
                /*0.判断用户填写的数据是否为空*/
                /*trim是去掉空格*/
                if(this.postContent.trim().length <= 0){
                    Toast('评论不能为空，请输入');
                    return;
                }
                /*1.确定提交的地址*/
//                http:wxtest.centaline.com.cn/api/api?type=postcomment&artid=59f179e5e370ee17f05af22d&content=Test

                /*get请求的地址*/
//                var url = api+'type=postcomment&artid='+this.id+'&content='+this.postContent;
//                console.log(url);

                /*get提交*/
//                this.$http.get(url).then(function (response) {
//                    console.log(response);
//                    if(response.body.status != 0){
//                        Toast('评论失败');
//                        return;
//                    }
//                    Toast('评论成功');
//                    this.commentList = [{
//                        user_name:"加载中……",
//                        user_logo:"http://wxtest.centaline.com.cn/haixinfang/images/ic_header_big.png",
//                        add_time:Date.now(),
//                        content:this.postContent,
//                    }].concat(this.commentList);
//                    console.log(this.commentList);
//                    /*将文本框中的评论内容清空*/
//                    this.postContent = '';
//                });

                /*post请求的地址*/
                var url = 'http://wxtest.centaline.com.cn/api/api';

                /*2.利用ajax的post请求将数据提交到指定的地址*/
                /*2.1 获取到用户的文本框中填写的评论内容，通过"content:内容"合适提交到请求报文体中*/
                /*post提交*/
                this.$http.post(url,
                    {content:this.postContent,
                        type:"postcomment",
                        artid:this.id},
                    {emulateJSON:true}).then(function (response) {
                        console.log(response);
//                        if (response.body.status != 0){
//                            Toast('评论失败');
//                            return;
//                        }
                        Toast('评论成功');
                        this.commentList = [{
                            "user_name":"加载中……",
                            "user_logo":"http://wxtest.centaline.com.cn/haixinfang/images/ic_header_big.png",
                            "add_time":Date.now(),
                            "content":this.postContent,
                        }].concat(this.commentList);

                    /*3.将文本框中的评论内容清空*/
                    this.postContent = '';
                });




            }
        }
    }
</script>

<style scoped>
    .postComment{
        padding: 35px 8px 0 8px;
        /*border: 1px solid red;*/
    }
    textarea{
        margin-bottom: 5px;
    }
    .lineP{
        height: 3px;
        width: 100%;
        border-bottom:1px solid rgba(0,0,0,0.3);
    }
    .mui-media-body span{
        margin-right: 20px;
        display: inline-block;
        line-height: 32px;
        margin-top: 2px;
        color: #fff;
        margin-bottom: 1px;

    }
    .mui-table-view-cell .mui-media-body{
        background-color: rgba(0,0,0,0.5);
        height: 32px;
        border-radius: 4px;
    }
    .mui-media-body img{
        width: 28px;
        height: 28px;
        margin-left: 5px;
        margin-top: 2px;
    }
    .mui-table-view a{
        padding: 0;
    }
    .mui-ellipsis{
        margin: 10px;
    }
</style>
