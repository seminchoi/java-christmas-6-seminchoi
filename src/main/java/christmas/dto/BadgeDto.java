package christmas.dto;

import christmas.message.TitleMessage;
import christmas.model.event.EventKind;
import christmas.model.event.badge.Badge;

public record BadgeDto(String eventKind, String badgeName) {
    public static BadgeDto of(final Badge badge) {
        final EventKind event = badge.getEventKind();
        final String eventDescription = event.getDescription();
        final String badgeName = badge.getDescription();
        return new BadgeDto(eventDescription, badgeName);
    }

    @Override
    public String toString() {
        final String title = String.format(TitleMessage.getTitleFormat(), eventKind);
        return title + badgeName + "\n";
    }
}
