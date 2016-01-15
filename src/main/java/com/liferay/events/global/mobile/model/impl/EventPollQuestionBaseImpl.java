package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.EventPollQuestion;
import com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the EventPollQuestion service. Represents a row in the &quot;Matcher_EventPollQuestion&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link EventPollQuestionImpl}.
 * </p>
 *
 * @author James Falkner
 * @see EventPollQuestionImpl
 * @see com.liferay.events.global.mobile.model.EventPollQuestion
 * @generated
 */
public abstract class EventPollQuestionBaseImpl
    extends EventPollQuestionModelImpl implements EventPollQuestion {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a event poll question model instance should use the {@link EventPollQuestion} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            EventPollQuestionLocalServiceUtil.addEventPollQuestion(this);
        } else {
            EventPollQuestionLocalServiceUtil.updateEventPollQuestion(this);
        }
    }
}
