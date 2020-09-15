<template>
  <div id="JobT_1" >
    <!-- 表格显示岗位调动报表 -->
    <el-table :data="JobTableData" :stripe="true" :border="true" width="100%" :header-cell-style="{color:'#000000',fontSize:'20px'}">
      <el-table-column label="原岗位编号" prop="bJobno" width="150px"></el-table-column>
      <el-table-column label="原岗位名称" prop="bJob" width="150px"></el-table-column>
      <el-table-column label="现岗位编号" prop="nowJobno" width="150px"></el-table-column>
      <el-table-column label="现岗位名称" prop="nowJob"></el-table-column>
      <el-table-column label="员工编号" prop="bpno"></el-table-column>
      <el-table-column label="员工姓名" prop="bpname"></el-table-column>
      <el-table-column label="员工性别" prop="bpsex"></el-table-column>
      <el-table-column label="用工形式" prop="bpyongg"></el-table-column>
      <el-table-column label="是否试用" prop="bpshiyong"></el-table-column>
      <el-table-column label="调转类型" prop="btype"></el-table-column>
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
  export default {
    name:"JobT",
    data(){
      return{
        JobTableData:[],
        size:5,
        currentPage:1,
        totalCount:0,
      }
    },

    mounted(){
      this.JobTable()
    },

    methods:{

      JobTable(){
        var JobTableDatas = new URLSearchParams()
        JobTableDatas.append("currentPage",this.currentPage)
        JobTableDatas.append("size",this.size)
        this.$axios.post('/TableServlet?method=tableJob',JobTableDatas).then((res)=>{
          if(res.status == 200){
            this.$message({
              type:"success",
              message:"查询报表成功"
            });
            var job = res.data
            this.JobTableData = job.pageData
            this.totalCount = job.totalCount
          }else{
            this.$message.error("查询失败")
          }
        }).catch((error)=>{
          console.log("错误原因："+res.data.message)
        })
      },
      // 分页操作
      handleCurrentChange(pagenum){
        this.currentPage = pagenum
        this.JobTable()
      },
    }

  }
</script>

<style>
  #JobT_1{
    width: 1500px;
    margin: 0px auto;
  }
</style>
