import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/login'
import Layout from '@/views/layout'
import Information from '@/views/information'
import Moviedetails from '@/views/moviedetails'
import Popular from '@/views/popular'
import Recom from '@/views/recom'
import Search from '@/views/search'
import InformationInfor from '@/views/information/infor'
import InformationStore from '@/views/information/store'
import InformationAdd from '@/views/information/add'
import MainLogin from '@/views/login/login'
import Register from '@/views/login/register'

import store from '@/store'

Vue.use(VueRouter)


const router = new VueRouter({
  routes: [
    { path: '/', redirect: '/MainLogin' },
    { path: '/information', redirect: '/infor' },
    {
      path: '/login', component: Login, children: [
        { path: '/mainlogin', component: MainLogin },
        { path: '/register', component: Register },
      ]
    },
    { path: '/layout', component: Layout },
    {
      path: '/information', component: Information,
      children: [
        { path: '/infor', component: InformationInfor },
        { path: '/store', component: InformationStore },
        { path: '/add', component: InformationAdd }
      ]
    },
    { path: '/moviedetails', component: Moviedetails },
    { path: '/popular', component: Popular },
    { path: '/recom', component: Recom },
    { path: '/search', component: Search },
  ]
})

// 全局前置导航守卫
// to到哪去，from从哪来，next()直接放行，next(路径)指定路径

const authUrls = ['/layout', '/information', '/infor', '/rate', '/store', '/moviedetails', '/popular', '/recom', '/search']

router.beforeEach((to, from, next) => {
  if (!authUrls.includes(to.path)) {
    document.body.scrollTop = 0; // firefox
    document.documentElement.scrollTop = 0; // safari
    window.pageYOffset = 0;
    next()
    return
  }

  const user_id = store.getters.getUserId
  if (user_id) {   //user_id必须存在才能跳转到其他页面，不然只能在登陆页面
    document.body.scrollTop = 0; // firefox
    document.documentElement.scrollTop = 0; // safari
    window.pageYOffset = 0;
    next()
  } else {
    next('/mainlogin')
  }
})

export default router
