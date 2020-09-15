<template>
  <div id="DeptT">
    <!-- 表格显示部门调动报表 -->
    <el-table :data="DeptBaoData" :stripe="true" :border="true" width="100%" :header-cell-style="{color:'#000000',fontSize:'20px'}">
      <el-table-column label="原部门编号" prop="bdeptno" width="150px"></el-table-column>
      <el-table-column label="原部门名称" prop="bdept" width="150px"></el-table-column>
      <el-table-column label="现部门编号" prop="nowDeptno" width="150px"></el-table-column>
      <el-table-column label="现部门名称" prop="nowDept"></el-table-column>
      <el-table-column label="员工编号" prop="bpno"></el-table-column>
      <el-table-column label="员工姓名" prop="bpname"></el-table-column>
      <el-table-column label="员工性别" prop="bpsex"></el-table-column>
      <el-table-column label="用工形式" prop="bpyongg"></el-table-column>
      <el-table-column label="是否试用" prop="bpshiyong"></el-table-column>
      <el-table-column label="调转类型" prop="bdtype"></el-table-column>
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
    name:'DeptT',
    data(){
      return {
        DeptBaoData:[],
        size:5,
        currentPage:1,
        totalCount:0,
      }
    },

    // 钩子函数，载入后调用
    mounted(){
      this.DeptTableDatas()
    },
    methods:{
      // 查询报表
      DeptTableDatas(){
        var tableData = new URLSearchParams()
        tableData.append("currentPage",this.currentPage)
        tableData.append("size",this.size)
        this.$axios.post('/TableServlet?method=tableDept',tableData).then((res)=>{
          if(res.status == 200){
            this.$message({
              type: 'success',
              message: '查询报表成功!'
            });
            var deptdata = res.data
            this.DeptBaoData = deptdata.pageData
            this.totalCount = deptdata.totalCount
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
  #DeptT{
    width: 1500px;
    margin: 0px auto;
  }
</style>
