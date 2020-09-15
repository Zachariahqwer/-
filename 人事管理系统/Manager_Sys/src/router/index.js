import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/Login'
import Body from '@/components/Body'
import Dept from '@/components/Dept'
import Job from '@/components/Job'
import Per from '@/components/per'
import Bao from '@/components/Baobiao'
import JobT from '@/components/JobTable'
import DeptT from '@/components/DeptTable'
import Depar from '@/components/DeparTable'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path:'/Body',
      name:'body',
      component:Body
    },
    {
      path:"/Dept",
      name:'Dept',
      component:Dept,
    },
    {
      path:"/Job",
      name:'Job',
      component:Job
    },
    {
      path:"/Per",
      name:'Per',
      component:Per
    },
    {
      path:"/Bao",
      name:"Bao",
      component:Bao,
      children:[
        {
          path:"/Bao/JobT",
          name:"JobT",
          component:JobT
        },
        {
          path:"/Bao/DeptT",
          name:"DeptT",
          component:DeptT
        },
        {
          path:"/Bao/Depar",
          name:"Depar",
          component:Depar
        },
      ],
    },
  ]
})
