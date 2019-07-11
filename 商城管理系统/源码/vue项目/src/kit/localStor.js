/**
 * Created by 小草莓 on 2017/11/26.
 */
/*负责操作localStorage的帮助文件*/
/*固定写法：
获取数据：var Str = localStorage.getItem(key);
添加和追加数据：localStorage.setItem(key,value),value是一个字符串
移除数据：localStorage.removeItem(key);
 */

/*1.定义常量key,将来操作的localStorage中的数据都以这个key来作为标识*/
export const KEY = 'goodsData';
export var valueObj = {goodsId:0,count:0};

/*2.实现数据的增加*/
/*格式：{goodsId:0,count:0*/
export function setItem(value) {
    /*获取json数据*/
    var jsonString = localStorage.getItem(KEY);
    /*容错，若为空则赋值为空的数组*/
    jsonString = jsonString || '[]';
    /*转换为json文件*/
    /*JSON.parse()用来解析JSON字符串，构造由字符串描述的JavaScript值或对象*/
    /*parse用于从一个字符串中解析出json对象*/
    var arr = JSON.parse(jsonString);//'[]'解析成[]，'{}'解析成{}

    /*将value追加进入arr*/
    arr.push(value);

    /*将arr转化成json字符串保存起来*/
    /*格式：{goodsId:0,count:0}*/
    /*JSON.stringify()用于从一个对象解析出字符串*/
    localStorage.setItem(KEY,JSON.stringify(arr));
}

/*3.获取数据*/
export function getItem() {
    var jsonString = localStorage.getItem(KEY);

    /*将json格式字符串转化成js对象*/
    /*jsonString:是一个标准的json格式*/
    jsonString = jsonString || '[]';
    return JSON.parse(jsonString);
}

/*4.移除数据*/
export function removeItem(goodsId) {
    var arr = getItem();
    /*查找arr中的id和传入的参数中的id一致的数据，全部移除*/
    for (var i = arr.length-1; i >= 0; i--) {
       if(arr[i].goodsId == goodsId){
           arr.splice(i,1);
       }
    }
    /*将最新的arr保存在localStorage中*/
    localStorage.setItem(KEY,JSON.stringify(arr));
}

/*5.将localStorage中的数据全部整合成一个对象的形式*/
/*
格式：
{
商品的id值：商品的购买数量,
商品的id值：商品的购买数量,
}
 */
export function getGoodsObj() {
    var arr = getItem();
    /*将arr数组中的goodId相同的多个对象合并成一个对象*/
    var resObj = {};
    for (var i = 0; i < arr.length; i++) {
        var item = arr[i];
        if(!resObj[item.goodsId]){
            /*如果当前没有商品的数据，则添加一个数据*/
            resObj[item.goodsId] = item.count;
        }else {
            /*当前已经有商品的数据了，则将count追加*/
            var count = resObj[item.goodsId];
            resObj[item.goodsId] = count + item.count;
        }
    }
    return resObj;
}

/*更新商品的数量*/
export function updateData(obj) {
    var arr = getItem();
    var count = 1;
    if(obj.type == 'increaseNumFun'){
        /*增加*/
        // console.log(obj);
        arr.push({goodsId:obj.goodsId,count:count});
    }else{
        /*减少*/
        for (var i = 0; i < arr.length; i++) {
           /*如果这个对象中的count值等于1，则删除这个对象，否则将这个对象的count减1以后保存回去*/
           if(arr[i].goodsId == obj.goodsId){
               if(arr[i].count > 1){
                   arr[i].count = arr[i].count - 1;
                   break;
               }else{
                   /*删除此对象*/
                   arr.splice(i,1);
                   break;
               }
           }

        }
    }
    /*将最新的arr保存回localStorage中*/
    localStorage.setItem(KEY,JSON.stringify(arr));
}