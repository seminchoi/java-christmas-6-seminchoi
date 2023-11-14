package christmas.dto;

import christmas.message.TitleMessage;
import christmas.model.event.badge.Badge;

public record BadgeDto(String eventKind, String badgeName) {
    public static BadgeDto of(final Badge badge) {
        final String eventKind = badge.getEventKind().getDescription();
        final String badgeName = badge.getDescription();
        return new BadgeDto(eventKind, badgeName);
    }

    @Override
    public String toString() {
        final String title = String.format(TitleMessage.getTitleFormat(), eventKind);
        return title + badgeName + "\n";
    }
}
