import React, { useState } from 'react';
import { useNavigate } from "react-router-dom";
import { Grid, Typography, Button } from '@material-ui/core';

import useStyles from './styles';

const TownUsers = () => {
    const classes = useStyles();
    const navigate = useNavigate();

    const towns = [
        { name: "최OO [이장]" },
        { name: "이OO [단말기]" },
        { name: "박OO [단말기]" },
        { name: "김OO [어플]" },
        { name: "이OO [어플]" },
        { name: "박OO [단말기]" },
        { name: "이OO [어플]" },
        { name: "김OO [단말기]" },
        { name: "이OO [단말기]" },
        { name: "박OO [어플]" },
        { name: "이OO [단말기]" },
        { name: "김OO [단말기]" },
        { name: "이OO [단말기]" },
        { name: "박OO [어플]" },
        { name: "이OO [단말기]" },
        { name: "김OO [단말기]" },
        { name: "박OO [단말기]" },
    ];

    return (
        <>
           <div className={classes.container} style={{margin: '10px', background: '#FFFFFF'}}>
                <Grid container spacing={1} className={classes.list}>
                    {towns?.map((town, i) => (
                        <Grid item key={i} xs={12}>
                            <Button onClick={() => navigate("/user")}>{town.name}</Button>
                        </Grid>
                    ))}
                </Grid>
            </div>
        </>
    );
}

export default TownUsers;