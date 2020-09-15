<template>
  <div id="box">
  	<div id="h1">
  		<h1>人事管理系统{{$route.query.u}}</h1>
  	</div>
  	<hr>
  
  	<div id="body_1">
  		<div class="body_li"><a href="#/Dept">部门管理入口</a></div>
  		<div class="body_li"><a href="#/Job">岗位管理入口</a></div>
  		<div class="body_li"><a href="#/Per">员工入职管理入口</a></div>
  		<div class="body_li"><a href="#/Bao">报表管理入口</a></div>
  	</div>
  
  </div>
</template>

<script>
  export default{
    name:'Body',
  }
</script>

<style>
  #body_1{
  	border: 1px solid #000000;
  	padding: 40px;
  	text-align: center;
  	/* width: 100%px; */
  	margin: 0px auto;
  }
  .body_li{
  	background-color: aquamarine;
  	padding: 10px;
  	margin-left: 80px;
  	line-height: 50px;
  	height: 50px;
  	border: 1px solid #000000;
  	display: inline-block;
  }
</style>
