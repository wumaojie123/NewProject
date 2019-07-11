/*打包入口*/

/*1.导入vue核心包*/
import Vue from 'vue';
import VueRouter from 'vue-router';
/*一定要注意，必须在vue中使用VueRouter*/
Vue.use(VueRouter);

/*导入vue-source包（发送网络请求）并且使用该对象*/
import vueSource from 'vue-resource';
Vue.use(vueSource);
/*导入vue-preview包，使得图片可以放大预览*/
import VuePreview from 'vue-preview';
Vue.use(VuePreview);

/*导入第三方组件mint-ui*/
/*样式*/
import 'mint-ui/lib/style.min.css';
/*组件*/
import mintUi from 'mint-ui';
/*使用对象*/
Vue.use(mintUi);

/*导入第三方组件mui*/
import '../statics/mui/css/mui.css';
import '../statics/mui/css/icons-extra.css';


/*导入类库momentjs第三方的时间格式化工具*/
import moment from 'moment';
/*过滤器的实现*/
/*定义一个全局过滤器*/
/*参数1：需要被过滤的数据*/
/*参数2：回调函数*/
Vue.filter('datefmt',function (input, fmtstring) {
    return moment(input).format(fmtstring)
});

/*2.导入App.vue的vue对象*/
import App from './App.vue';




/*导入组件*/
import shopcar from './components/shopcar/shopcar.vue';
import Home from './components/Home.vue';
import newList from './components/news/newList.vue';
import newsinfo from './components/news/newsinfo.vue';
import photoList from './components/photo/photoList.vue';
import photoInfo from './components/photo/photoInfo.vue';
import goodList from './components/goods/goodList.vue';
import goodInfo from './components/goods/goodInfo.vue';
import goodDesc from './components/goods/goodDesc.vue';
import goodComment from './components/goods/goodComment.vue';

/*导入全局样式*/
import '../statics/css/site.css';

/*设置路由规则*/
var route1 = new VueRouter({
    /*Vue的路由配置router-link-active这个名字是可以通过配置改变的,可以改成名字为mui-active*/
    /*改变激活时的类名*/
    linkActiveClass:'mui-active',

    routes:[
        {path:'/',redirect:'/Home'},
        {path:'/shopcar',component:shopcar},
        {path:'/Home',component:Home},
        /*新闻资讯列表页面*/
        {path:'/news/newList',component:newList},
        /*新闻资讯详情页面*/
        {path:'/news/newsinfo/:id',component:newsinfo},
        {path:'/photo/photoList',component:photoList},
        {path:'/photo/photoInfo/:id',component:photoInfo},
        {path:'/goods/goodList',component:goodList},
        {path:'/goods/goodInfo/:id',component:goodInfo},
        {path:'/goods/goodDesc/:id',component:goodDesc},
        {path:'/goods/goodComment/:id',component:goodComment},
    ]
});

/*3.利用vue对象进行渲染*/
new Vue({
    el:'#app',
    router:route1,

    // render函数是vue里面的默认函数，为了解析.vue文件
    /*ES6的写法:箭头函数*/
    /*解析上面的组件*/
    render:create=>create(App)
});



