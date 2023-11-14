package christmas.view;

import static christmas.message.OutputMessage.*;
import static christmas.message.TitleMessage.*;

import christmas.dto.BadgeDto;
import christmas.dto.EventPlannerDto;
import christmas.message.MessageBuilder;
import christmas.message.OutputMessage;
import christmas.message.TitleMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class OutputView {
    public void printEventPlanner(final EventPlannerDto eventPlannerDto) {
        MessageBuilder messageBuilder = new MessageBuilder();
        List<Consumer<MessageBuilder>> consumersForShortCircuit = createConsumersForShortCircuit(eventPlannerDto);

        messageBuilder.makeShortCircuits(consumersForShortCircuit);

        System.out.println(messageBuilder);
    }

    public List<Consumer<MessageBuilder>> createConsumersForShortCircuit(final EventPlannerDto eventPlannerDto) {
        List<Consumer<MessageBuilder>> consumers = new ArrayList<>();

        consumers.add(createPlannerTitleConsumer(eventPlannerDto));
        consumers.add(createClientOrderMenusConsumer(eventPlannerDto));
        consumers.add(createAmountBeforeDiscountConsumer(eventPlannerDto));
        consumers.add(createGiftOrdersConsumer(eventPlannerDto));
        consumers.add(createBenefitsConsumer(eventPlannerDto));
        consumers.add(createBenefitAmountConsumer(eventPlannerDto));
        consumers.add(createFinalAmountConsumer(eventPlannerDto));
        consumers.addAll(createBadgesConsumers(eventPlannerDto));

        return consumers;
    }

    private Consumer<MessageBuilder> createPlannerTitleConsumer(final EventPlannerDto eventPlannerDto) {
        return (messageBuilder) -> {
            String plannerTitle = String.format(INTRODUCTION_FORMAT.getMessage(), eventPlannerDto.date());
            messageBuilder.append(plannerTitle);
        };
    }

    private Consumer<MessageBuilder> createClientOrderMenusConsumer(final EventPlannerDto eventPlannerDto) {
        return (messageBuilder) -> {
            messageBuilder.append(CLIENT_ORDER_MENU_TITLE.getMessage());

            appendMessageByDetails(messageBuilder, eventPlannerDto.clientOrders(), ORDER_FORMAT);
        };
    }

    private Consumer<MessageBuilder> createAmountBeforeDiscountConsumer(final EventPlannerDto eventPlannerDto) {
        return (messageBuilder) -> {
            messageBuilder.append(AMOUNT_BEFORE_DISCOUNT_TITLE.getMessage());

            String amountDetail = String.format(AMOUNT_FORMAT.getMessage(), eventPlannerDto.amountBeforeDiscount());
            messageBuilder.append(amountDetail);
        };
    }

    private Consumer<MessageBuilder> createGiftOrdersConsumer(final EventPlannerDto eventPlannerDto) {
        return (messageBuilder) -> {
            messageBuilder.append(GIFT_ORDERS_TITLE.getMessage());

            appendMessageByDetails(messageBuilder, eventPlannerDto.giftOrders(), ORDER_FORMAT);
        };
    }

    private Consumer<MessageBuilder> createBenefitsConsumer(final EventPlannerDto eventPlannerDto) {
        return (messageBuilder) -> {
            messageBuilder.append(BENEFITS_TITLE.getMessage());

            appendMessageByDetails(messageBuilder, eventPlannerDto.benefits(), BENEFIT_FORMAT);
        };
    }

    private void appendMessageByDetails(
            MessageBuilder builder, Map<String, Integer> details, OutputMessage message
    ) {
        if (details.isEmpty()) {
            builder.append(NOTHING.getMessage());
            return;
        }

        for (String key : details.keySet()) {
            String detail = String.format(message.getMessage(), key, details.get(key));
            builder.append(detail);
        }
    }

    private Consumer<MessageBuilder> createBenefitAmountConsumer(final EventPlannerDto eventPlannerDto) {
        return (messageBuilder) -> {
            messageBuilder.append(BENEFIT_AMOUNT_TITLE.getMessage());

            String amount = getAmountMessage(eventPlannerDto.benefitAmount());
            messageBuilder.append(amount);
        };
    }

    private String getAmountMessage(int amount) {
        if(isAmountZero(amount)) {
            return NOTHING.getMessage();
        }
        return String.format(AMOUNT_FORMAT.getMessage(), amount);
    }

    private boolean isAmountZero(int amount) {
        return amount == 0;
    }

    private Consumer<MessageBuilder> createFinalAmountConsumer(final EventPlannerDto eventPlannerDto) {
        return (messageBuilder) -> {
            messageBuilder.append(FINAL_AMOUNT_TITLE.getMessage());

            String amount = String.format(AMOUNT_FORMAT.getMessage(), eventPlannerDto.finalAmount());
            messageBuilder.append(amount);
        };
    }

    private List<Consumer<MessageBuilder>> createBadgesConsumers(final EventPlannerDto eventPlannerDto) {
        List<Consumer<MessageBuilder>> consumers = new ArrayList<>();

        BadgeDto badge = eventPlannerDto.badge();
        //TODO : 뱃지 출력

        return consumers;
    }

    private Consumer<MessageBuilder> createBadgeConsumer(final String event, final String badge) {
        return (messageBuilder) -> {
            String title = String.format(TitleMessage.getTitleFormat(), event);
            messageBuilder.append(title);
            messageBuilder.append(badge);
        };
    }

    public void printErrorMessage(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
