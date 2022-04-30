package com.timcook.capstone.message.factory;

import java.util.List;

import com.timcook.capstone.message.domain.AbstractMessage;
import com.timcook.capstone.message.domain.DetectMessage;
import com.timcook.capstone.message.dto.MessageCreateRequsetInterface;

public abstract class AbstractMessageFactory {
	abstract AbstractMessage create(MessageType messageType, MessageCreateRequsetInterface abstarctMessageCreateRequest);
}
