<template>
    <div id="box">
        <!--引用mui组件中图片列表组件实现-->
        <ul class="mui-table-view">
            <li v-for="(item,index) in listNew" class="mui-table-view-cell mui-media" >
                <router-link v-bind="{to:'/news/newsinfo/'+item.id}">
                    <img class="mui-media-object mui-pull-left" :src="item.img_url">
                    <div class="mui-media-body">
                        {{item.title}}
                        <p class='mui-ellipsis'>{{item.zhaiyao}}</p>
                        <!--使用datefmt过滤器组件-->
                        <div class="newListpub">
                            <!--<span>发表时间：{{item.add_time}}</span>-->
                            <span>发表时间：{{item.add_time | datefmt('YYYY-MM-DD')}}</span>
                            <span class="clickNum">点击数：{{item.click}}</span>
                        </div>
                    </div>
                </router-link>
            </li>
        </ul>
    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    export default{
        data(){
            return {
                listNew:[
//                        {"id":"59f179e5e370ee17f05af22b",
//                        "title":"买苹果7之前 先看看关于iPhone7的20个新功能吧",
//                        "add_time":"2017-10-26 14:00:05",
//                        "zhaiyao":"哪些苹果7的这20个新功能 买iPhone7前必看！",
//                        "click":206,
//                        "img_url":"http://wxtest.centaline.com.cn/api/upload/news/1474593629430.jpg"
//                },
//                        {"id":"59f179e5e370ee17f05af22d","title":"iPhone 8无线充电功能","add_time":"2017-10-25 14:00:05","zhaiyao":"苹果公布支持iPhone 8的无线充电功能的车型","click":50,"img_url":"http://wxtest.centaline.com.cn/api/upload/news/2017102514384929.jpg"},
//                        {"id":"59f7d7fee370ed2cfc31b935","title":"买苹果7之前 先看看关于iPhone7的20个新功能吧","add_time":"2017-10-31 09:55:10","zhaiyao":"哪些苹果7的这20个新功能 买iPhone7前必看！","click":26,"img_url":"http://wxtest.centaline.com.cn/api/upload/news/1474593629430.jpg"},
//                        {"id":"59f7d7fee370ed2cfc31b937","title":"iPhone 8无线充电功能","add_time":"2017-10-30 09:55:10","zhaiyao":"苹果公布支持iPhone 8的无线充电功能的车型","click":13,"img_url":"http://wxtest.centaline.com.cn/api/upload/news/2017102514384929.jpg"}
                     ]
            }
        },
        created(){
           this.getNewList();
        },
        methods:{
            getNewList(){
                var url = 'http://wxtest.centaline.com.cn/api/api?type= getnewslist';
                this.$http.get(url).then(function (response) {
                    if (response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
                    this.listNew = response.body.message;
                })
            }
        }
    }
</script>

<style scoped>
    .mui-table-view img{
        width: 100%;
        height: 100%;
    }
    .mui-table-view .mui-media-object{
        height: 80px;
        max-width: 80px;
        line-height: 80px;
    }
    .mui-media-body{
        /*color:#02C1ED;*/
        font-size: 18px;
        font-weight: 600;
    }
    .mui-ellipsis{
        font-weight:normal;
        margin-top: 10px;
    }
    .newListpub{
        /*background-color: red;*/
        margin-top: 10px;
        color:#02C1ED;
        font-weight:normal;
        text-wrap: none;
        font-size: 14px;
    }
   .clickNum{
       margin-left: 20px;
   }
</style>
