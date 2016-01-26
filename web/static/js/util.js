//工具类对象
var util = function () {

};
//工具类easyui下的
util.easyui = function () {

}

util.easyui.datagrid = function () {
    //请求url
    this.urls = "http://localhost:8080/datagrid.do";
    //datagrid的id
    this.dId = "datagrid";
    //顶级父类
    var firstParent = this;
    //用于条件查询
    this.loadParams={};
    //datagrid的参数
    this.dParams = {
        fit: true,
        fitColumns: true,
        border: false,
        pagination: true,
        idField: 'name',
        checkOnSelect: false,
        selectOnCheck: false,
        pageSize: 10,
        pageList: [10, 15, 20, 25, 30],
        url: firstParent.urls,
        method: 'post',
        pagination: true,
        pagePosition: "bottom",
        //默认工具条
        toolbar: '#toolbar',
        //表格数据
        columns:[],
        onLoadSuccess: function () {
            parent.$.messager.progress('close');
            //$(this).datagrid('tooltip');
        }
    }
    //加载datagrid
    this.init=function(){
        $('#'+firstParent.dId).datagrid(firstParent.dParams);
    }
    this.load = function() {
        $("#datagrid").datagrid("load",firstParent.loadParams);
    };
}
