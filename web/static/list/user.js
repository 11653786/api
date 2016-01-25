$(function () {
    var datagrids=new util.easyui.datagrid();
    datagrids.dParams.columns=[[{field: 'name', title: 'Name', width: 100}]];
    //初始化了
    datagrids.init();
    datagrids.loadParams={"sql":"123"};
    $("#aa").click(function(){
        datagrids.load();
    });

});