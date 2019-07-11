$(function () {
    //定义变量
    var index = 0;
    var timer = 0;
    //显示和隐藏其他元素
    showAndHideOtherEle();

    //滚滚屏幕
    $(window).mousewheel(function (event) {
        //使用一次性定时器进行节流，保证得到的是最后一次滚动
        timer = setTimeout(function () {
            //先清空定时器
            clearTimeout(timer);
            //取其方向，向上滚为1，向下滚为-1
            var del = event.deltaY > 0 ? 1 : -1 ;
            //计算索引
            index = index - del;
            //判断临界值
            if (index > $('.gps li').length - 1){
                index = $('.gps li').length - 1;
            }else if (index < 0 ){
                index = 0;
            }
            //切换小白点
            $('.gps li').eq(index).addClass('current').siblings().removeClass('current');
            //切屏
            $('section').eq(index).show().siblings('section').hide();
            //显示和隐藏其他元素
            showAndHideOtherEle();
            //落空类(设置一次性定时器，500毫秒之后再移出类)
            toggleCurrent();
        },500);

    });


    //监听小圆点点击事件
    $(".gps li").on('click',function () {
        //拿到索引
        index = $(this).index();
        //切换小白点
        $(this).addClass('current').siblings().removeClass('current');
        //切换屏
        $('section').eq(index).show().siblings('section').hide();
        //显示和隐藏其他元素
        showAndHideOtherEle();

        //落空类(设置一次性定时器，500毫秒之后再移出类)
        toggleCurrent();
    });


    //显示和隐藏其他元素
    function showAndHideOtherEle() {
        if (index == 0){
            $('.scroll').show();
            $('.header_left').hide();
        }else {
            $('.scroll').hide();
            $('.header_left').show();
        }
    }
    //落空类(设置一次性定时器，500毫秒之后再移出类)
    function toggleCurrent() {
        setTimeout(function () {
            $('section').eq(index).removeClass('current').siblings('section').addClass('current');
        },50);
    }

});