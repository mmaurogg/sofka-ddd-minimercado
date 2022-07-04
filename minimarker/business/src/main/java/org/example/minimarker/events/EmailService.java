package org.example.minimarker.events;

import org.example.minimarker.client.values.ClientId;

public interface EmailService {

    public void sendEmail(ClientId clientId, String body);
}
