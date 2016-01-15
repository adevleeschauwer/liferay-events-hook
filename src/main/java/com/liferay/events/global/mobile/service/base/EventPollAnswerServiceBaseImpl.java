package com.liferay.events.global.mobile.service.base;

import com.liferay.events.global.mobile.model.EventPollAnswer;
import com.liferay.events.global.mobile.service.EventPollAnswerService;
import com.liferay.events.global.mobile.service.persistence.EventContactPersistence;
import com.liferay.events.global.mobile.service.persistence.EventPollAnswerPersistence;
import com.liferay.events.global.mobile.service.persistence.EventPollQuestionPersistence;
import com.liferay.events.global.mobile.service.persistence.GeoCachePersistence;
import com.liferay.events.global.mobile.service.persistence.MatchPersistence;
import com.liferay.events.global.mobile.service.persistence.MessagePersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the event poll answer remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.events.global.mobile.service.impl.EventPollAnswerServiceImpl}.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.impl.EventPollAnswerServiceImpl
 * @see com.liferay.events.global.mobile.service.EventPollAnswerServiceUtil
 * @generated
 */
public abstract class EventPollAnswerServiceBaseImpl extends BaseServiceImpl
    implements EventPollAnswerService, IdentifiableBean {
    @BeanReference(type = com.liferay.events.global.mobile.service.EventContactLocalService.class)
    protected com.liferay.events.global.mobile.service.EventContactLocalService eventContactLocalService;
    @BeanReference(type = com.liferay.events.global.mobile.service.EventContactService.class)
    protected com.liferay.events.global.mobile.service.EventContactService eventContactService;
    @BeanReference(type = EventContactPersistence.class)
    protected EventContactPersistence eventContactPersistence;
    @BeanReference(type = com.liferay.events.global.mobile.service.EventPollAnswerLocalService.class)
    protected com.liferay.events.global.mobile.service.EventPollAnswerLocalService eventPollAnswerLocalService;
    @BeanReference(type = com.liferay.events.global.mobile.service.EventPollAnswerService.class)
    protected com.liferay.events.global.mobile.service.EventPollAnswerService eventPollAnswerService;
    @BeanReference(type = EventPollAnswerPersistence.class)
    protected EventPollAnswerPersistence eventPollAnswerPersistence;
    @BeanReference(type = com.liferay.events.global.mobile.service.EventPollQuestionLocalService.class)
    protected com.liferay.events.global.mobile.service.EventPollQuestionLocalService eventPollQuestionLocalService;
    @BeanReference(type = com.liferay.events.global.mobile.service.EventPollQuestionService.class)
    protected com.liferay.events.global.mobile.service.EventPollQuestionService eventPollQuestionService;
    @BeanReference(type = EventPollQuestionPersistence.class)
    protected EventPollQuestionPersistence eventPollQuestionPersistence;
    @BeanReference(type = com.liferay.events.global.mobile.service.GeoCacheLocalService.class)
    protected com.liferay.events.global.mobile.service.GeoCacheLocalService geoCacheLocalService;
    @BeanReference(type = GeoCachePersistence.class)
    protected GeoCachePersistence geoCachePersistence;
    @BeanReference(type = com.liferay.events.global.mobile.service.MatchLocalService.class)
    protected com.liferay.events.global.mobile.service.MatchLocalService matchLocalService;
    @BeanReference(type = com.liferay.events.global.mobile.service.MatchService.class)
    protected com.liferay.events.global.mobile.service.MatchService matchService;
    @BeanReference(type = MatchPersistence.class)
    protected MatchPersistence matchPersistence;
    @BeanReference(type = com.liferay.events.global.mobile.service.MessageLocalService.class)
    protected com.liferay.events.global.mobile.service.MessageLocalService messageLocalService;
    @BeanReference(type = com.liferay.events.global.mobile.service.MessageService.class)
    protected com.liferay.events.global.mobile.service.MessageService messageService;
    @BeanReference(type = MessagePersistence.class)
    protected MessagePersistence messagePersistence;
    @BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
    protected com.liferay.counter.service.CounterLocalService counterLocalService;
    @BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
    protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
    @BeanReference(type = com.liferay.portal.service.UserLocalService.class)
    protected com.liferay.portal.service.UserLocalService userLocalService;
    @BeanReference(type = com.liferay.portal.service.UserService.class)
    protected com.liferay.portal.service.UserService userService;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;
    private String _beanIdentifier;
    private ClassLoader _classLoader;
    private EventPollAnswerServiceClpInvoker _clpInvoker = new EventPollAnswerServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.liferay.events.global.mobile.service.EventPollAnswerServiceUtil} to access the event poll answer remote service.
     */

    /**
     * Returns the event contact local service.
     *
     * @return the event contact local service
     */
    public com.liferay.events.global.mobile.service.EventContactLocalService getEventContactLocalService() {
        return eventContactLocalService;
    }

    /**
     * Sets the event contact local service.
     *
     * @param eventContactLocalService the event contact local service
     */
    public void setEventContactLocalService(
        com.liferay.events.global.mobile.service.EventContactLocalService eventContactLocalService) {
        this.eventContactLocalService = eventContactLocalService;
    }

    /**
     * Returns the event contact remote service.
     *
     * @return the event contact remote service
     */
    public com.liferay.events.global.mobile.service.EventContactService getEventContactService() {
        return eventContactService;
    }

    /**
     * Sets the event contact remote service.
     *
     * @param eventContactService the event contact remote service
     */
    public void setEventContactService(
        com.liferay.events.global.mobile.service.EventContactService eventContactService) {
        this.eventContactService = eventContactService;
    }

    /**
     * Returns the event contact persistence.
     *
     * @return the event contact persistence
     */
    public EventContactPersistence getEventContactPersistence() {
        return eventContactPersistence;
    }

    /**
     * Sets the event contact persistence.
     *
     * @param eventContactPersistence the event contact persistence
     */
    public void setEventContactPersistence(
        EventContactPersistence eventContactPersistence) {
        this.eventContactPersistence = eventContactPersistence;
    }

    /**
     * Returns the event poll answer local service.
     *
     * @return the event poll answer local service
     */
    public com.liferay.events.global.mobile.service.EventPollAnswerLocalService getEventPollAnswerLocalService() {
        return eventPollAnswerLocalService;
    }

    /**
     * Sets the event poll answer local service.
     *
     * @param eventPollAnswerLocalService the event poll answer local service
     */
    public void setEventPollAnswerLocalService(
        com.liferay.events.global.mobile.service.EventPollAnswerLocalService eventPollAnswerLocalService) {
        this.eventPollAnswerLocalService = eventPollAnswerLocalService;
    }

    /**
     * Returns the event poll answer remote service.
     *
     * @return the event poll answer remote service
     */
    public com.liferay.events.global.mobile.service.EventPollAnswerService getEventPollAnswerService() {
        return eventPollAnswerService;
    }

    /**
     * Sets the event poll answer remote service.
     *
     * @param eventPollAnswerService the event poll answer remote service
     */
    public void setEventPollAnswerService(
        com.liferay.events.global.mobile.service.EventPollAnswerService eventPollAnswerService) {
        this.eventPollAnswerService = eventPollAnswerService;
    }

    /**
     * Returns the event poll answer persistence.
     *
     * @return the event poll answer persistence
     */
    public EventPollAnswerPersistence getEventPollAnswerPersistence() {
        return eventPollAnswerPersistence;
    }

    /**
     * Sets the event poll answer persistence.
     *
     * @param eventPollAnswerPersistence the event poll answer persistence
     */
    public void setEventPollAnswerPersistence(
        EventPollAnswerPersistence eventPollAnswerPersistence) {
        this.eventPollAnswerPersistence = eventPollAnswerPersistence;
    }

    /**
     * Returns the event poll question local service.
     *
     * @return the event poll question local service
     */
    public com.liferay.events.global.mobile.service.EventPollQuestionLocalService getEventPollQuestionLocalService() {
        return eventPollQuestionLocalService;
    }

    /**
     * Sets the event poll question local service.
     *
     * @param eventPollQuestionLocalService the event poll question local service
     */
    public void setEventPollQuestionLocalService(
        com.liferay.events.global.mobile.service.EventPollQuestionLocalService eventPollQuestionLocalService) {
        this.eventPollQuestionLocalService = eventPollQuestionLocalService;
    }

    /**
     * Returns the event poll question remote service.
     *
     * @return the event poll question remote service
     */
    public com.liferay.events.global.mobile.service.EventPollQuestionService getEventPollQuestionService() {
        return eventPollQuestionService;
    }

    /**
     * Sets the event poll question remote service.
     *
     * @param eventPollQuestionService the event poll question remote service
     */
    public void setEventPollQuestionService(
        com.liferay.events.global.mobile.service.EventPollQuestionService eventPollQuestionService) {
        this.eventPollQuestionService = eventPollQuestionService;
    }

    /**
     * Returns the event poll question persistence.
     *
     * @return the event poll question persistence
     */
    public EventPollQuestionPersistence getEventPollQuestionPersistence() {
        return eventPollQuestionPersistence;
    }

    /**
     * Sets the event poll question persistence.
     *
     * @param eventPollQuestionPersistence the event poll question persistence
     */
    public void setEventPollQuestionPersistence(
        EventPollQuestionPersistence eventPollQuestionPersistence) {
        this.eventPollQuestionPersistence = eventPollQuestionPersistence;
    }

    /**
     * Returns the geo cache local service.
     *
     * @return the geo cache local service
     */
    public com.liferay.events.global.mobile.service.GeoCacheLocalService getGeoCacheLocalService() {
        return geoCacheLocalService;
    }

    /**
     * Sets the geo cache local service.
     *
     * @param geoCacheLocalService the geo cache local service
     */
    public void setGeoCacheLocalService(
        com.liferay.events.global.mobile.service.GeoCacheLocalService geoCacheLocalService) {
        this.geoCacheLocalService = geoCacheLocalService;
    }

    /**
     * Returns the geo cache persistence.
     *
     * @return the geo cache persistence
     */
    public GeoCachePersistence getGeoCachePersistence() {
        return geoCachePersistence;
    }

    /**
     * Sets the geo cache persistence.
     *
     * @param geoCachePersistence the geo cache persistence
     */
    public void setGeoCachePersistence(GeoCachePersistence geoCachePersistence) {
        this.geoCachePersistence = geoCachePersistence;
    }

    /**
     * Returns the match local service.
     *
     * @return the match local service
     */
    public com.liferay.events.global.mobile.service.MatchLocalService getMatchLocalService() {
        return matchLocalService;
    }

    /**
     * Sets the match local service.
     *
     * @param matchLocalService the match local service
     */
    public void setMatchLocalService(
        com.liferay.events.global.mobile.service.MatchLocalService matchLocalService) {
        this.matchLocalService = matchLocalService;
    }

    /**
     * Returns the match remote service.
     *
     * @return the match remote service
     */
    public com.liferay.events.global.mobile.service.MatchService getMatchService() {
        return matchService;
    }

    /**
     * Sets the match remote service.
     *
     * @param matchService the match remote service
     */
    public void setMatchService(
        com.liferay.events.global.mobile.service.MatchService matchService) {
        this.matchService = matchService;
    }

    /**
     * Returns the match persistence.
     *
     * @return the match persistence
     */
    public MatchPersistence getMatchPersistence() {
        return matchPersistence;
    }

    /**
     * Sets the match persistence.
     *
     * @param matchPersistence the match persistence
     */
    public void setMatchPersistence(MatchPersistence matchPersistence) {
        this.matchPersistence = matchPersistence;
    }

    /**
     * Returns the message local service.
     *
     * @return the message local service
     */
    public com.liferay.events.global.mobile.service.MessageLocalService getMessageLocalService() {
        return messageLocalService;
    }

    /**
     * Sets the message local service.
     *
     * @param messageLocalService the message local service
     */
    public void setMessageLocalService(
        com.liferay.events.global.mobile.service.MessageLocalService messageLocalService) {
        this.messageLocalService = messageLocalService;
    }

    /**
     * Returns the message remote service.
     *
     * @return the message remote service
     */
    public com.liferay.events.global.mobile.service.MessageService getMessageService() {
        return messageService;
    }

    /**
     * Sets the message remote service.
     *
     * @param messageService the message remote service
     */
    public void setMessageService(
        com.liferay.events.global.mobile.service.MessageService messageService) {
        this.messageService = messageService;
    }

    /**
     * Returns the message persistence.
     *
     * @return the message persistence
     */
    public MessagePersistence getMessagePersistence() {
        return messagePersistence;
    }

    /**
     * Sets the message persistence.
     *
     * @param messagePersistence the message persistence
     */
    public void setMessagePersistence(MessagePersistence messagePersistence) {
        this.messagePersistence = messagePersistence;
    }

    /**
     * Returns the counter local service.
     *
     * @return the counter local service
     */
    public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
        return counterLocalService;
    }

    /**
     * Sets the counter local service.
     *
     * @param counterLocalService the counter local service
     */
    public void setCounterLocalService(
        com.liferay.counter.service.CounterLocalService counterLocalService) {
        this.counterLocalService = counterLocalService;
    }

    /**
     * Returns the resource local service.
     *
     * @return the resource local service
     */
    public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
        return resourceLocalService;
    }

    /**
     * Sets the resource local service.
     *
     * @param resourceLocalService the resource local service
     */
    public void setResourceLocalService(
        com.liferay.portal.service.ResourceLocalService resourceLocalService) {
        this.resourceLocalService = resourceLocalService;
    }

    /**
     * Returns the user local service.
     *
     * @return the user local service
     */
    public com.liferay.portal.service.UserLocalService getUserLocalService() {
        return userLocalService;
    }

    /**
     * Sets the user local service.
     *
     * @param userLocalService the user local service
     */
    public void setUserLocalService(
        com.liferay.portal.service.UserLocalService userLocalService) {
        this.userLocalService = userLocalService;
    }

    /**
     * Returns the user remote service.
     *
     * @return the user remote service
     */
    public com.liferay.portal.service.UserService getUserService() {
        return userService;
    }

    /**
     * Sets the user remote service.
     *
     * @param userService the user remote service
     */
    public void setUserService(
        com.liferay.portal.service.UserService userService) {
        this.userService = userService;
    }

    /**
     * Returns the user persistence.
     *
     * @return the user persistence
     */
    public UserPersistence getUserPersistence() {
        return userPersistence;
    }

    /**
     * Sets the user persistence.
     *
     * @param userPersistence the user persistence
     */
    public void setUserPersistence(UserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    public void afterPropertiesSet() {
        Class<?> clazz = getClass();

        _classLoader = clazz.getClassLoader();
    }

    public void destroy() {
    }

    /**
     * Returns the Spring bean ID for this bean.
     *
     * @return the Spring bean ID for this bean
     */
    @Override
    public String getBeanIdentifier() {
        return _beanIdentifier;
    }

    /**
     * Sets the Spring bean ID for this bean.
     *
     * @param beanIdentifier the Spring bean ID for this bean
     */
    @Override
    public void setBeanIdentifier(String beanIdentifier) {
        _beanIdentifier = beanIdentifier;
    }

    @Override
    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        Thread currentThread = Thread.currentThread();

        ClassLoader contextClassLoader = currentThread.getContextClassLoader();

        if (contextClassLoader != _classLoader) {
            currentThread.setContextClassLoader(_classLoader);
        }

        try {
            return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
        } finally {
            if (contextClassLoader != _classLoader) {
                currentThread.setContextClassLoader(contextClassLoader);
            }
        }
    }

    protected Class<?> getModelClass() {
        return EventPollAnswer.class;
    }

    protected String getModelClassName() {
        return EventPollAnswer.class.getName();
    }

    /**
     * Performs an SQL query.
     *
     * @param sql the sql query
     */
    protected void runSQL(String sql) throws SystemException {
        try {
            DataSource dataSource = eventPollAnswerPersistence.getDataSource();

            SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
                    sql, new int[0]);

            sqlUpdate.update();
        } catch (Exception e) {
            throw new SystemException(e);
        }
    }
}
