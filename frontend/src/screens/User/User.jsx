import React, { useEffect, useState, Component } from 'react';

import { CssBaseline, Grid, Button, IconButton, Input, Tabs, Tab, Box, Typography} from '@material-ui/core';
import { AddCircleRounded, Close, Settings, Delete } from '@material-ui/icons';

import Header from '../../components/Header/Header';
import UserDetail from '../../components/UserDetail/UserDetail';
import GuardDetail from '../../components/GuardDetail/GuardDetail';
import Monitoring from '../../components/Monitoring/Monitoring';
import useStyles from './styles';

const User = () => {
    const classes = useStyles();
    
    return (
        <div id="user" style={{margin: '40px', paddingTop: '80px'}}>
            <CssBaseline />
            <Header />

            <h1 style={{color: "#555555"}}>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                &lt;OO마을&gt; 충북 제천 봉양읍 팔송리  &#128034;&nbsp;&nbsp;&nbsp;&nbsp;
                <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 유저 김OO [단말기] &#128241;
            </h1>
            <div>
                <Grid container spacing={1} style={{width: '100%', margin: '40px'}}>
                    <Grid item xs={12} md={6} className={classes.info}>
                        <h2 style={{color: "#555555"}}>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#128100;&nbsp;
                            유저 정보
                        </h2>
                        <UserDetail/><br/>
                    </Grid>
                    <Grid item xs={12} md={6} className={classes.users}>
                        <h2 style={{color: "#555555"}}>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#127968;&nbsp;
                            보호자 정보
                        </h2>
                        <GuardDetail /><br/>
                    </Grid>
                    <Grid item xs={12} md={12} className={classes.users}style={{width: '80%'}}>
                        <h2 style={{color: "#555555"}}>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#128161;&nbsp;
                            상태 데이터
                        </h2>
                        <Monitoring />
                    </Grid>
                </Grid>
            </div>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Button color="error" size="small" variant="contained" onClick={()=>alert("이장으로 등록하시겠습니까?")} className={classes.cheifbtn}>
                <h3 className={classes.cheiftxt}>이장 등록</h3>
            </Button>
        </div>
    );
}

export default User;