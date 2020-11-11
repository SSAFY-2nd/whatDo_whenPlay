<template>
<div class="navigation" style="z-index:1; background-color: #FFD0D6;">
<!-- <div class="navigation" style="z-index:1; background-color: #232323"> -->
    <div class="navigation-container" id="header">
        <!-- <span class ="image-container"> -->
            <router-link v-bind:to="{name:constants.URL_TYPE.POST.MAIN}">
                <img class="navigation-logo" src="../../assets/img/brand_main.png">
            </router-link>
        <!-- </span> -->
        <nav role='navigation' class="nav-list d-none d-sm-block">
            
        </nav>
        <nav class="mobile-nav d-block d-sm-none">
            <div class="dropdown">
                
            </div>
        </nav>
        <div class="navigation-loginBtn">
            
        </div>
    </div>
</div>
</template>

<script>
import '../../assets/css/header.scss'
import constants from '../../lib/constants.js'
// import Login from '../../page/user/Login.vue'

export default {
    name: 'Header',
    components: {
        // Login,
    },
    props: ['isHeader'],
    computed: {},
    watch: {},
    created() {
        // 세션 스토리지에 토큰 key 자체가 있는가 ..?
        if("jwt-auth-token" in sessionStorage){
            // 만약 세션스트로지에 token이 있다면 ? 토큰이 유효한지 서버에 보내 본다 
            if (sessionStorage.getItem('jwt-auth-token') !== ""){
            this.$store.dispatch('GETINFO',{nickname:sessionStorage.getItem("user_nickname")});
        }
        }else{
            sessionStorage.setItem('jwt-auth-token', ""); 
            sessionStorage.setItem('user_nickname', ""); 
        }
        

    },
    methods: {
        onClickLogout() {
            //console.log("test")
            this.$store.dispatch('LOGOUT')
                .then(
                    //console.log(sessionStorage.getItem('jwt-auth-token'))
                )
        },
        test() {
            //console.log(this.$store.state.guide);
        },
        onClickGuidePart(part) {
            // 부위별 링크 처리
            // store에 있는 video state를 변경
            this.$store.dispatch('PART', part)
                .then(() => {
                        //console.log("header success")
                        // this.$router.push('/guide')
                    }
                )
                .catch(
                    //console.log("header error")
                )
        }
    },
    data: function () {
        return {
            constants,
            keyword: "",
        }
    },
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap');

* {
    font-family: 'Jua', sans-serif;
}

/* @media screen and (max-width: 426px) {
    a {
        min-width: 0px;
        margin: 0px;
        padding: 5px;
        width: 60px;
    }
    nav > ul > li {
        width: 60px;
    }
    .navigation-container {
        padding: 5px;
        margin: 0px;
        width: 100%;
        max-width: 100%;
    }
    nav {
        width: 100%;
    }
} */

nav {
    margin-left: 15px;
    width: 80%;
}

nav ul{
    list-style: none;
    /* //position: relative;
    //float: left;
    //margin-right: 100px;
    //display: inline-table; */
}
nav ul li{
    float: left;
    -webkit-transition: all .2s ease-in-out;
    -moz-transition: all .2s ease-in-out;
    transition: all .2s ease-in-out;
}

nav ul li:hover {
    background: rgba(0,0,0,.15);
}
/* nav ul li:hover > ul, li{display: block;} */
nav ul li{
    float: left;
    -webkit-transition: all .2s ease-in-out;
    -moz-transition: all .2s ease-in-out;
    transition: all .2s ease-in-out;
}
nav ul li a{
    min-width: 100px;
    display: block; 
    padding: 20px 20px 20px;
    color: white; 
    font-size: .9em;
    letter-spacing: 1px;
    text-decoration: none;
    text-transform: uppercase;
}
nav ul li a:hover {
    color: #FFBD07;
}
/* nav ul ul{
    display: none;
    background: #fff;
    position: absolute; 
    top: 100%;
    box-shadow: -3px 3px 10px -2px rgba(0,0,0,.1);
    border: 1px solid rgba(0,0,0,.1);
}
nav ul ul li{float: none; position: relative;}
nav ul ul li a {
    padding: 15px 30px; 
    border-bottom: 1px solid rgba(0,0,0,.05);
    color: black;
} */
nav ul .pt-link {
  width: 102.74px;
}
/* nav ul ul ul {
    position: absolute; 
    left: 100%; 
    top:0;
}	 */
.navigation-user{
    color:#ffffff
}
/* img{
    position: relative;
    width: 60%;
    height: 100%;
} */
.dropdown-toggle {
    background-color: transparent;
    border: none;
}
</style>
