<template>
    <div id="zikuHome">
        <div id="top">
            <div id="top-first">
                <img src="../../../screenshot/logo.jpg"  />
            </div>
        </div>
        <div id="top-then">
            <div id="top-nav">
                <ul class="firstNav">
                    <li>
                        <a href="#">工作室介绍</a>
                    </li>
                    <li>
                        <a href="#">关于我们</a>
                    </li>
                    <li>
                        <a href="#">购买产品</a>
                    </li>
                </ul>
            </div>
        </div>
        <div id="center">
            <div id="center-left">
                <ul>
                    <li style="text-align: left;"><h3>宝贝分类</h3></li>
                    <li><a href="#"><span>51开发板</span></a></li>
                    <li><a href="#"><span>SMT32开发板</span></a></li>
                    <li><a href="#"><span>DIY散装套件</span></a></li>
                </ul>
            </div>
            <div id="center-right">
                <div id="iamge-list">
                    <el-row :gutter="20">
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                        <el-col :span="8">
                            <img src="../../../screenshot/test1.jpg" />
                        </el-col>
                    </el-row>
                </div>
            </div>
        </div>
        <div id="bottom"></div>
    </div>
</template>

<style>

    #zikuHome {
        width: 100%;
        height: 100%;
        /*background: url(../../../screenshot/background.jpg) no-repeat center 0*/
        background-color: cornflowerblue;
    }

    #top {
        width: 100%;
        height: 18%;
        background-color: white;
    }

    #top-first {
        width: 80%;
        height: 10%;
        margin: 0 15% ;
    }

    #top-then {
        text-align: center;
        width: 100%;
        height: 6%;
        padding-left: 27%;
        margin: 0 auto; /*居中*/
    }

    #top-nav li {
        display: block;
        float: left;
        text-align: center;
        font-weight: bold;
    }

    #center-left li {
        height: 26px;
        line-height: 26px;
        font-size: 16px;
        margin-top: 10px;
        list-style: none;
        font-weight: bold;
        text-decoration: none
    }

    #center-left a {
        height: 30px;
        line-height: 30px;
        text-align: center;
        text-decoration: none;
    }

    #top-nav a {
        height: 30px;
        line-height: 30px;
        text-align: center;
        text-decoration: none;
        padding: 30px;
    }

    li:hover {
        background-color: #0c1365;
    }

    #center {
        width: 100%;
        height: 62%;
        background-color: cornflowerblue;
        opacity: 80%; /*透明度*/
        overflow:auto;
    }

    #center-left {
        width: 12%;
        background-color: white;
        margin: 0 14%; /*居中*/
        float: left;
        position: absolute;
    }

    #center-right {
        width: 50%;
        background-color: white;
        margin-left: 30%;
        position: relative;
    }

    #iamge-list{
        overflow:auto;
        padding-top: 20px;
    }

    #iamge-list img{
        padding-top: 10px;
        padding-left: 10px;
        width: auto;
        max-width: 100%;
    }

    #bottom {
        width: 100%;
        height: 15%;
        background-color: #1b3d65;
    }

</style>
<script>
    export default {
        data() {
            return {
                form: {
                    username: '',
                    password: ''
                },
                loading: false,
                url: "../../../screenshot/test1.jpg",
                fit: 'fill',
            }
        },
        methods: {
            login() {
                this.loading = true;
                setTimeout(() => {
                    this.$router.push({path: "/home"});
                    this.loading = false;
                }, 1000);

            },
            register() {
                this.$router.push({path: "/register"});
            }
        }
    }
</script>