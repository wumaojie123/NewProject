<!--页面入口-->

<!--后面所有.vue组件的入口-->
<!--下面的这三个部分其实就是webpack所识别的.Vue文件-->
<template>
    <div>

        <!--头部-->
        <!--利用mint-ui的header组件设置页面的头部-->
        <mt-header fixed title="广师vue商城系统"></mt-header>

        <!--统一的返回按钮-->
        <div id="back" v-if="isShow">
            <a href="javascript:void(0)" @click="backTo">返回</a>
        </div>

        <!--中间内容-->
        <router-view></router-view>

        <!--底部-->
        <!--利用mui的tabbar组件设置页面的底部-->
        <!--将原本的a标签给成vue的路由标签-->
        <!--后面所有的变化都是路由的变化,现在改成vue2.0路由变化的配置 将a标签换成 router-link  将href换成 to=”/”-->
        <nav class="mui-bar mui-bar-tab">
            <router-link class="mui-tab-item" to="/Home">
                <span class="mui-icon mui-icon-home"></span>
                <span class="mui-tab-label">首页</span>
            </router-link>
            <router-link class="mui-tab-item" to="/custom">
                <span class="mui-icon mui-icon-email"></span>
                <span class="mui-tab-label">会员</span>
            </router-link>
            <router-link class="mui-tab-item" to="/shopcar">
                <span class="mui-icon mui-icon-contact">
                    <span class="mui-badge" id="badge">0</span>
                </span>
                <span class="mui-tab-label">购物车</span>
            </router-link>
            <router-link class="mui-tab-item" to="/search">
                <span class="mui-icon mui-icon-gear"></span>
                <span class="mui-tab-label">搜索</span>
            </router-link>
        </nav>
    </div>

</template>


<script>
    import {vm,COUNT} from './kit/vm.js';

    /*接收goodInfo组件传递过来的数据*/
    vm.$on(COUNT,function (count) {
        /*1.0将count值追加到购物车上*/
        console.log(count);
        var badgeObj = document.querySelector('#badge');
        badgeObj.innerText = parseInt(badgeObj.innerText)+count;
    });

//将当前组件导出
    //ES6的语法
    export default{
       methods:{
           /*回退按钮的实现*/
           backTo(){
               /*利用路由对象中的go(-1)来实现返回到上一级页面，这个方法是vue-router的方法*/
               this.$router.go(-1);
           }
       },
        data(){
           return{
               isShow:false
           }
        },
        /*watch脏值检测*/
        /*检测路由是否为主页，若为主页则不隐藏*/
        watch:{
            '$route':function (newRoute,oldRoute) {
                if(newRoute.path.toLocaleLowerCase() == '/home'){
                    this.isShow = false;
                }else {
                    this.isShow = true;
                }
            }
        }

    }
</script>

<!--scoped的作用是为了将当前的样式固定在本作用域,不会影响其他组件页面-->
<!--在这里写的样式不是全局的，只作用在本组件。在css文件夹中写的样式是全局的-->
<style scoped>
    #back{
        width: 60px;
        position: absolute;
        top: 10px;
        left: 10px;
        z-index: 998;
    }
    #back a{
        color: white;
        font-size: 16px;
        font-weight:bold;
    }
</style>
