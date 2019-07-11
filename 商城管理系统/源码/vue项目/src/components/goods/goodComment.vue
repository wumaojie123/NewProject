<template>
    <div id="box">
        <!--组件显示的区域-->
        <comment :id="id"></comment>
    </div>
</template>

<script>
    /*导入组件*/
    import comment from '../subcom/comment.vue';

    export default{
        /*定义组件*/
        components:{
            comment
        },
       data(){
           return{
               id:''
           }
       },
        created(){
           /*路由传参*/
           this.id = this.$route.params.id;
        }
    }
</script>

<style scoped>
    
</style>
