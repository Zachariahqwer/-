<template>
  <div id="depar">
    <!-- 表格显示离职员工报表 -->
    <el-table :data="DeparTableData" :stripe="true" :border="true" width="100%" :header-cell-style="{color:'#000000',fontSize:'20px'}">
      <el-table-column label="部门编号" prop="ldeptno" width="150px"></el-table-column>
      <el-table-column label="部门名称" prop="ldept" width="150px"></el-table-column>
      <el-table-column label="岗位编号" prop="ljobno" width="150px"></el-table-column>
      <el-table-column label="岗位名称" prop="ljob"></el-table-column>
      <el-table-column label="员工编号" prop="lpno"></el-table-column>
      <el-table-column label="员工姓名" prop="lpname"></el-table-column>
      <el-table-column label="员工性别" prop="lpsex"></el-table-column>
      <el-table-column label="用工形式" prop="lpyongg"></el-table-column>
      <el-table-column label="是否试用" prop="lpshiyong"></el-table-column>
      <el-table-column label="是否离职" prop="lizhi"></el-table-column>
      <el-table-column label="离职日期" prop="ldate"></el-table-column>
      <el-table-column label="离职类型" prop="ltype"></el-table-column>
    </el-table>
    <el-pagination
      background
      :page-size="size"
      :current-page="currentPage"
      @current-change="handleCurrentChange"
      layout="prev, pager, next"
      :total="totalCount">
    </el-pagination>
  </div>
</template>

<script>
  export default{
    name:'Depar',
    data(){
      return {
        DeparTableData:[],
        size:5,
        currentPage:1,
        totalCount:0,
      }
    },

    // 钩子函数，载入后调用
    mounted(){
      this.DeparTableDatas()
    },
    methods:{
      // 查询报表
      DeparTableDatas(){
        var tableData = new URLSearchParams()
        tableData.append("currentPage",this.currentPage)
        tableData.append("size",this.size)
        this.$axios.post('/TableServlet?method=tablePer',tableData).then((res)=>{
          if(res.status == 200){
            this.$message({
              type: 'success',
              message: '查询报表成功!'
            });
            var depardata = res.data
            this.DeparTableData = depardata.pageData
            this.totalCount = depardata.totalCount
          }else{
            this.$message.error('查询失败')
          }
        }).catch((error)=>{
          console.log("错误信息："+error)
        })
      },

      // 分页操作
      handleCurrentChange(pagenum){
        this.currentPage = pagenum
        this.DeptTableDatas()
      },
    }
  }
</script>

<style>
  #depar{
    width: 1500px;
    margin: 0px auto;
  }
</style>
