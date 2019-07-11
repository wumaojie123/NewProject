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
        data(){
            return{
                /*购买的数量*/
                count:0
            }
        },
       methods:{
           decNumFun(){
               this.count--;
               if(this.count < 0 ){
                   this.count=0;
                   Toast('购买数量不能为负数哦！');
               }
               /*每点击一次调用一次*/
               this.sendMessage();

           },
           increaseNumFun(){
               this.count++;
               /*每点击一次调用一次*/
               this.sendMessage();
           },
           /*发送信息*/
           /*消息的名称，消息的内容*/
           sendMessage(){
               this.$emit('dataObj',this.count);
           }
       }
    }
</script>

<style scoped>
    #box1 div{
        width: 40px;
        height: 25px;
        line-height: 25px;
        border: 1px solid #000;
        display: inline-block;
        text-align: center;
    }
</style>
