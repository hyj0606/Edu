import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

import Layout from '../views/layout/Layout'

export const constantRouterMap = [
  { path: '/login', component: () => import('@/views/login/index'), hidden: true },
  { path: '/404', component: () => import('@/views/404'), hidden: true },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    name: 'Dashboard',
    hidden: true,
    children: [{
      path: 'dashboard',
      component: () => import('@/views/dashboard/index')
    }]
  },

  // 讲师管理
  {
    path: '/teacher',
    component: Layout,
    redirect: '/teacher/list',
    name: 'Teacher',
    meta: { title: '讲师管理', icon: 'peoples' },
    children: [
      {
        path: 'list',
        name: 'TeacherList',
        component: () => import('@/views/teacher/list'),
        meta: { title: '讲师列表', icon: 'peoples' }
      },
      {
        path: 'create',
        name: 'TeacherCreate',
        component: () => import('@/views/teacher/form'),
        meta: { title: '添加讲师', icon: 'form'}
      },
      {
        path: 'edit/:id',
        name: 'TeacherEdit',
        component: () => import('@/views/teacher/form'),
        meta: {title: '编辑讲师', icon: 'edit'},
        hidden: true
      }
    ]
  },

  // 课程分类
  {
    path: '/subject',
    component: Layout,
    redirect: '/subject/list',
    name: 'Subject',
    meta: { title: '课程分类管理', icon: 'example' },
    children: [
      {
        path: 'list',
        name: 'SubjectList',
        component: () => import('@/views/subject/list'),
        meta: { title: '课程分类列表', icon: 'table' }
      },
      {
        path: 'create',
        name: 'TeacherCreate',
        component: () => import('@/views/subject/import'),
        meta: { title: '添加课程分类', icon: 'excel'}
      }
    ]
  },

  { path: '*', redirect: '/404', hidden: true }
]

export default new Router({
  // mode: 'history', //后端支持可开
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRouterMap
})
