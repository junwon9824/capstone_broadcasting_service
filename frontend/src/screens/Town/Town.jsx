import React, { useEffect, useState, Component } from 'react';
import { useLocation } from "react-router";
import Modal from 'react-modal';
import axios from 'axios';

import { CssBaseline, Grid, Button, IconButton, Input, Tabs, Tab, Box, Typography} from '@material-ui/core';
import { AddCircleRounded, Close, Settings, Delete } from '@material-ui/icons';

import Header from '../../components/Header/Header';
import TownUsers from '../../components/TownUsers/TownUsers';
import TownDetail from '../../components/TownDetail/TownDetail';
import Weather from '../../components/Weather/Weather';
import useStyles from './styles';

const Town = () => {
    const classes = useStyles();
    const { state } = useLocation();
    const [users, setUsers] = useState([{}]);
    
    const [value, setValue] = React.useState(0);
    const [modalIsOpen, setModalIsOpen] = useState(false);

    const axios = require('axios');
    const userurl = `http://localhost:8080/api/villages/${state.id}/users`;
    //const villurl = `http://localhost:8080/api/villages/${state.id}`;

    const handleChange = (e, newValue) => {
        setValue(newValue);
    };

    const town = {
        devusers: "00",
        appusers: "00",
        guardians: "00",
        emergencycall: "00",
        communicationfail: "00"
    };

    function getData() {
        axios.get(villurl)
            .then(function(response) {
                setVillages(response.data);
            }).catch(function(error) {
                console.log(error);
        });
    }
/////////////////weather 값 town에서 불러오기

    useEffect(() => {
        getData();
    }, [])

    function getUsers() {
        // axios.get(userurl)
        //     .then(function(response) {
        //         setUsers(response.data);
        //     }).catch(function(error) {
        //         console.log(error);
        // });
    }

    useEffect(() => {
        getUsers();
    }, [])

    return (
        <div id="town" style={{margin: '40px', paddingTop: '60px'}} >
            <CssBaseline />
            <Header />

            <h1 style={{color: "#555555"}}>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                &lt; {state.nickname} &gt; {state.city} {state.state} {state.town} &#128034;
            </h1> 
            <h4 style={{color: "#989898"}}>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                ID: {state.id}, 마을 좌표: 위도 {state.location.latitude}, 경도 {state.location.longitude}
            </h4>
            <div>
                <Grid container spacing={1} style={{width: '100%', margin: '20px'}}>
                    <Grid item xs={12} sm={12} md={3} className={classes.weather} style={{margin: '20px'}}>
                        <Weather coord={state.location}/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={4} className={classes.info}>
                        <h2 style={{color: "#555555"}}>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#127968;&nbsp;
                            마을 정보
                        </h2>
                        <TownDetail town={town}/><br/>
                    </Grid>
                    <Grid item xs={12} sm={12} md={4} className={classes.users}>
                        <h2 style={{color: "#555555"}}>
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#128100;&nbsp;
                            마을 주민 목록
                        </h2>
                        <TownUsers town={town}/>
                    </Grid>
                </Grid>
                <label htmlFor="icon-button-file" >
                    <IconButton color="disabled" aria-label="add" component="span" id="add-btn" 
                        className={classes.editbtn} onClick={() => setModalIsOpen(true)}>
                        <Settings fontSize="large" color="disabled" />
                    </IconButton>
                    <IconButton color="error" aria-label="add" component="span" id="add-btn" 
                        className={classes.deletebtn} onClick={() => {
                            const tmp = state.nickname;
                            axios.delete(`http://localhost:8080/api/villages/${state.id}`)
                            .then(function (response) {
                                window.location.href='/';
                                alert(`${tmp}이(가) 삭제되었습니다.`);
                            })
                            .catch(function (error) {
                                console.log(error);
                            });
                        }}>
                        <Delete fontSize="large" />
                    </IconButton>
                    <Modal isOpen={modalIsOpen} onRequestClose={() => setModalIsOpen(false)}
                        style={{
                            overlay: {
                                position: 'fixed', backgroundColor: 'rgba(255, 255, 255, 0.75)'
                                , top: '0', left: '0', right: '0', bottom: '0'
                            },
                            content: {
                                position: 'fixed', top: '200px', left: '80px'
                                , width: '340px', height: '425px', backgroundColor: 'rgba(196, 196, 196, 0.85)'
                                , border: 'solid', borderRadius: '10px', borderColor: '#000000',
                            }
                        }}>
                        <div>
                            <form>
                                <h2 className={classes.title}> &nbsp;&#128190; 마을 정보 수정</h2>
                                <input className={classes.input} type="text" placeholder="  시 State" />
                                <input className={classes.input} type="text" placeholder="  구 City" />
                                <input className={classes.input} type="text" placeholder="  동 Town" />
                                <input className={classes.input} type="text" placeholder="  마을명 Nickname" /> 
                                <input className={classes.input} type="text" placeholder="  경도 Longitude" />
                                <input className={classes.input} type="text" placeholder="  위도 Latitude" /><br/>
                                <Button size="small" variant="contained" color="disabled" className={classes.inputbtn}>주소 수정</Button>
                                <Button size="small" variant="contained" color="disabled" className={classes.inputbtn} onClick={() => alert("이장을 삭제하시겠습니까?")}>이장 삭제</Button>
                                <h3>&nbsp;&nbsp;마을 이장 : [ID 00127920] 최이장</h3>
                            </form>
                        </div>
                        <IconButton color="action" aria-label="add" component="span"
                            className={classes.closebtn} onClick={() => setModalIsOpen(false)}>
                            <Close fontSize="large" color="action" />
                        </IconButton>
                    </Modal>
                </label>
            </div>
        </div>
    );
}

export default Town;