package com.timcook.capstone.common.mqtt;

import java.util.HashSet;

import org.springframework.data.util.Pair;

public class MqttBuffer {
	public static final HashSet<Pair<Long, Long>> REVICE_BUFFER = new HashSet<>();
	public static final HashSet<Pair<Long, Long>> CONFIRM_BUFFER = new HashSet<>();
}
