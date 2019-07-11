<template>
    <div id="box1">
        <div class="decNum" @click="decNumFun">-</div>
        <div class="num" v-text="count">6</div>
        <div class="increaseNum" @click="increaseNumFun">+</div>
    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    export default{
        /*父组件购物车传递给子组件购买的数量和对应的id*/
        props:['initCount','goodsId'],
        data(){
            return{
                /*购买的数量*/
               count:1,
                resObj:{goodsId:0,type:'increaseNumFun'}
            }
        },
        created(){
            this.count = this.initCount;
        },
       methods:{
           decNumFun(){
               this.count--;
               if(this.count < 0 ){
                   this.count=0;
                   Toast('购买数量不能为负数哦！');
               }
               /*每点击一次调用一次*/
               this.sendMessage('decNumFun');

           },
           increaseNumFun(){
               this.count++;
               /*每点击一次调用一次*/
               this.sendMessage('increaseNumFun');
           },
           /*发送信息*/
           /*子组件向父组件发送消息*/
           /*消息的名称，消息的内容*/
           /*点击了增加还是减少，记录点击的类型，还是点击的id*/
           sendMessage(type){
               this.resObj.type = type;
               this.resObj.goodsId = this.goodsId;
               this.$emit('carResObj',this.resObj);
           }
       }
    }
</script>

<style scoped>
    #box1 div{
        width: 30px;
        height: 25px;
        line-height: 25px;
        border: 1px solid #000;
        display: inline-block;
        text-align: center;
    }
</style>
