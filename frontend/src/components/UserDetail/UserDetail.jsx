import React, { useEffect, useState, Component } from 'react';
import Modal from 'react-modal';

import { Table, TableHead, TableRow, TableCell, TableContainer, Paper, TableBody } from '@material-ui/core';

import useStyles from './styles';

const UserDetail = () => {
    const classes = useStyles();

    return (
        <div className={classes.tablebody}>
            <TableContainer component={Paper}>
                <Table aria-label="simple table">
                    <TableRow sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">ID</TableCell>
                        <TableCell align="right">00</TableCell>
                    </TableRow>
                    <TableRow sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">연락처</TableCell>
                        <TableCell align="right">010-0000-0000</TableCell>
                    </TableRow>
                    <TableRow sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">주소</TableCell>
                        <TableCell align="right">충북 제천 봉양읍 팔송리 00-0</TableCell>
                    </TableRow>
                    <TableRow sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
                        <TableCell component="th" scope="row">temp</TableCell>
                        <TableCell align="right">00</TableCell>
                    </TableRow>
                </Table>
            </TableContainer>
        </div>
    );
}

export default UserDetail;