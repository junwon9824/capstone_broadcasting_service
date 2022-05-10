package com.timcook.capstone.message.factory;

import java.util.List;

import com.timcook.capstone.message.domain.AbstractMessage;
import com.timcook.capstone.message.domain.DetectMessage;
import com.timcook.capstone.message.domain.MessageType;
import com.timcook.capstone.message.dto.subscribe.MessageCreateRequsetInterface;

public abstract class AbstractMessageCreateRequestFactory {
	abstract MessageCreateRequsetInterface create(MessageType messageType, List<String> payload);
}
