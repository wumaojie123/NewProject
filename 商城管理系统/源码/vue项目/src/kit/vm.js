/**
 * Created by 小草莓 on 2017/11/26.
 */

/*定义一个全局的文件Vue,方面后面传值*/

/*但是内存中至始至终只有一个Vue,再定义一个vue是为了方便后面传值*/
import Vue from 'Vue';
export const COUNT = "inputNum";
export var vm = new Vue();