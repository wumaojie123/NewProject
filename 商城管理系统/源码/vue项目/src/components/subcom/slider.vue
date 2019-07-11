<template>
    <div class="box">
        <!--使用第三方组件mint-ui,实现轮播图的效果-->
        <mt-swipe :auto="4000" class="homeSpire">
            <mt-swipe-item  v-for="item in imgs">
                <img :src="item.src">
            </mt-swipe-item>
        </mt-swipe>

    </div>
</template>

<script>

    export default{
       /*接受父组件传递过来的数据*/
       props:['imgs']
    }
</script>

<style scoped>
    /*.box{*/
        /*margin-top: 30px;*/
        /*margin-bottom: 20px;*/
    /*}*/
</style>
