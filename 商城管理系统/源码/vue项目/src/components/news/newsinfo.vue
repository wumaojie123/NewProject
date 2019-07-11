<template>
    <div id="box">

        <!--实现新闻详情-->
      <div class="title">
          <h4 v-text="listInfo.title"></h4>
          <p>
              <span style="margin-right: 10px">{{listInfo.add_time | datefmt('YYYY-MM-DD')}}</span>
              {{listInfo.click}}次浏览
          </p>
      </div>
      <div class="content" v-html="listInfo.content"></div>

        <!--实现评论组件的集成-->
        <!--子组件要接收的内容是:id的值-->
        <comment :id="id"></comment>
    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    /*导入相同的地址*/
    import {api} from '../../kit/common.js';

    /*导入评论组件(子组件)*/
    import comment from '../subcom/comment.vue';

    export default{
        /*组件显示的区域*/
        components:{
            /*子组件*/
            comment
        },
        data(){
            return{
                id:0,
                listInfo: ''
//                    {
//                    "id":"59f179e5e370ee17f05af22b",
//                    "title":"买苹果7之前 先看看关于iPhone7的20个新功能吧",
//                    "click":396,"add_time":"2017-10-26 14:00:05",
//                    "content":"哪些苹果7的这20个新功能 买iPhone7前必看！ 你看或者不看，iPhone7就在那里，依然辣么贵。伴随着今年科技春晚--苹果秋季发布会的闭幕，之前关于iPhone7/7 Plus的种种传言也得到落实。虽然外观设计不变、没有颠覆性科技的加入让分析师普遍不太看好这代iPhone的销量，但从消费者角度来看iPhone发售的时候火爆依旧。关于iPhone7/7 Plus你可能还有一些事情不清楚，今天笔者就来和大家一起了解下。"
//                }
            }
        },
        created(){
            /*获取url传入的id参数，赋值给data中的id属性*/
            this.id = this.$route.params.id;
            /*获取列表中的数据*/
            this.getListInfo();
        },
        methods:{
            getListInfo(){
//                var url = 'http://wxtest.centaline.com.cn/api/api?type=getnew&newid=59f179e5e370ee17f05af22b';
                var url = api+'type=getnew&newid='+this.id;
                this.$http.get(url).then(function (response) {
                    if (response.body.status != 0){
                        Toast(response.body.message);
                        return;
                    }
//                    console.log(response.body.message);
                    this.listInfo = response.body.message;
                })
            }
        }

    }
</script>

<style scoped>
    .title
    {
        padding: 10px 8px 5px;
    }
    .title h4{
        color: #02C1ED;
    }
    .title p{
        color:rgba(0,0,0,0.5);
        padding-top: 5px;
        margin-bottom: 5px;
    }
    .content{
        padding: 0 5px;
        font-size: 16px;
        line-height: 25px;
        text-indent: 32px;
    }
</style>
