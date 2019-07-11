<template>
    <div id="box" class="goodDesc">
        <h4 v-html="dataList.title"></h4>
        <p class="line"></p>
        <p v-html="dataList.content" class="boxP"></p>
    </div>
</template>

<script>
    import {api} from '../../kit/common';
    import { Toast } from 'mint-ui';
    export default{
        data(){
            return{
                id:'',
                dataList:{}
            }
        },
       created(){
           /*路由传参*/
           this.id = this.$route.params.id;
           this.getData();
       },
        methods:{
           getData(){
              /*http://wxtest.centaline.com.cn/api/api?type=getdesc&id=59f176fce370ed17f00305d1*/
               var url = api + 'type=getdesc&id='+this.id;
               this.$http.get(url).then(function (response) {
                   if (response.body.status != 0){
                       Toast(response.body.message);
                       return;
                   }
                   this.dataList = response.body.message;
               })
           }
        }
    }
</script>

<style scoped>
    #box{
        padding: 5px;
    }
    #box h4{
        color: #0094ff;
    }
    #box .line{
        height: 1px;
        border: 1px solid rgba(0, 0, 0, 0.3);
    }
    .boxP{
        text-indent: 32px;
        line-height: 25px;
    }
    .boxP>p:nth-child(1){
        border: 1px solid yellow;
        color: #02C1ED;
    }
    .boxP>p:nth-child(2) img{
        width: 100px;
    }
</style>
