import Vue from 'vue'
import Router from 'vue-router'
import login from '@/views/login/index.vue'
import register from '@/views/register/index.vue'
import home from '@/views/home/index.vue'
import projectManagement from '@/views/projectManagement/thinkBaseInfoList.vue'
import error404 from '@/views/404/index.vue'
import homePage from '@/views/home/homePage.vue'

// 用户管理
import userList from '@/views/user/userList.vue'
import deptList from '@/views/user/deptList.vue'
import positionList from '@/views/user/positionList.vue'

// 附件管理
import attachmentList from '@/views/attach/attchmentList.vue'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: "/",
            redirect: '/homePage',
            hidden: true
        },
        {
            path: '/homePage',
            component: homePage,
            name: 'homePage',
            hidden: true,
            meta: {title: '首页'}
        },
        {
            path: '/login',
            component: login,
            name: 'login',
            hidden: true,
            meta: {title: '登录'}
        },
        {
            path: '/register',
            component: register,
            name: 'register',
            hidden: true,
            meta: {title: '注册'}
        },
        {
            path: '*',
            component: error404,
            name: '404',
            hidden: true,
            meta: {title: '404'}
        },
        {
            path: "/home",
            redirect: '/home/deptList',
            hidden: true
        },
        {
            path: '/home',
            name: 'home',
            component: home,
            children: [
                {
                    path: 'deptList',
                    name: 'deptList',
                    component: deptList,
                    meta: {title: '部门管理', icon: 'fa fa-user'}
                },
                {
                    path: 'positionList',
                    name: 'positionList',
                    component: positionList,
                    meta: {title: '岗位管理', icon: 'fa fa-user'}
                },
                {
                    path: 'user',
                    name: '用户管理',
                    component: userList,
                    meta: {title: '用户管理', icon: 'fa fa-user'}
                },
                {
                    path: 'projectManagement',
                    name: 'projectManagement',
                    component: projectManagement,
                    meta: {title: '产品管理', icon: 'fa fa-database'}
                },
                {
                    path: 'attachmentList',
                    name: 'attachmentList',
                    component: attachmentList,
                    meta: {title: '附件管理', icon: 'fa fa-file'}
                },
            ]
        }
    ]
})
