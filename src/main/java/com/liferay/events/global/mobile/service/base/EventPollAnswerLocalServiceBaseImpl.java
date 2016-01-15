package com.liferay.events.global.mobile.service.base;

import com.liferay.events.global.mobile.model.EventPollAnswer;
import com.liferay.events.global.mobile.service.EventPollAnswerLocalService;
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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the event poll answer local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.events.global.mobile.service.impl.EventPollAnswerLocalServiceImpl}.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.impl.EventPollAnswerLocalServiceImpl
 * @see com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil
 * @generated
 */
public abstract class EventPollAnswerLocalServiceBaseImpl
    extends BaseLocalServiceImpl implements EventPollAnswerLocalService,
        IdentifiableBean {
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
    private EventPollAnswerLocalServiceClpInvoker _clpInvoker = new EventPollAnswerLocalServiceClpInvoker();

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil} to access the event poll answer local service.
     */

    /**
     * Adds the event poll answer to the database. Also notifies the appropriate model listeners.
     *
     * @param eventPollAnswer the event poll answer
     * @return the event poll answer that was added
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public EventPollAnswer addEventPollAnswer(EventPollAnswer eventPollAnswer)
        throws SystemException {
        eventPollAnswer.setNew(true);

        return eventPollAnswerPersistence.update(eventPollAnswer);
    }

    /**
     * Creates a new event poll answer with the primary key. Does not add the event poll answer to the database.
     *
     * @param answerId the primary key for the new event poll answer
     * @return the new event poll answer
     */
    @Override
    public EventPollAnswer createEventPollAnswer(long answerId) {
        return eventPollAnswerPersistence.create(answerId);
    }

    /**
     * Deletes the event poll answer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param answerId the primary key of the event poll answer
     * @return the event poll answer that was removed
     * @throws PortalException if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public EventPollAnswer deleteEventPollAnswer(long answerId)
        throws PortalException, SystemException {
        return eventPollAnswerPersistence.remove(answerId);
    }

    /**
     * Deletes the event poll answer from the database. Also notifies the appropriate model listeners.
     *
     * @param eventPollAnswer the event poll answer
     * @return the event poll answer that was removed
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.DELETE)
    @Override
    public EventPollAnswer deleteEventPollAnswer(
        EventPollAnswer eventPollAnswer) throws SystemException {
        return eventPollAnswerPersistence.remove(eventPollAnswer);
    }

    @Override
    public DynamicQuery dynamicQuery() {
        Class<?> clazz = getClass();

        return DynamicQueryFactoryUtil.forClass(EventPollAnswer.class,
            clazz.getClassLoader());
    }

    /**
     * Performs a dynamic query on the database and returns the matching rows.
     *
     * @param dynamicQuery the dynamic query
     * @return the matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return eventPollAnswerPersistence.findWithDynamicQuery(dynamicQuery);
    }

    /**
     * Performs a dynamic query on the database and returns a range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @return the range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return eventPollAnswerPersistence.findWithDynamicQuery(dynamicQuery,
            start, end);
    }

    /**
     * Performs a dynamic query on the database and returns an ordered range of the matching rows.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param dynamicQuery the dynamic query
     * @param start the lower bound of the range of model instances
     * @param end the upper bound of the range of model instances (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching rows
     * @throws SystemException if a system exception occurred
     */
    @Override
    @SuppressWarnings("rawtypes")
    public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return eventPollAnswerPersistence.findWithDynamicQuery(dynamicQuery,
            start, end, orderByComparator);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery)
        throws SystemException {
        return eventPollAnswerPersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Returns the number of rows that match the dynamic query.
     *
     * @param dynamicQuery the dynamic query
     * @param projection the projection to apply to the query
     * @return the number of rows that match the dynamic query
     * @throws SystemException if a system exception occurred
     */
    @Override
    public long dynamicQueryCount(DynamicQuery dynamicQuery,
        Projection projection) throws SystemException {
        return eventPollAnswerPersistence.countWithDynamicQuery(dynamicQuery,
            projection);
    }

    @Override
    public EventPollAnswer fetchEventPollAnswer(long answerId)
        throws SystemException {
        return eventPollAnswerPersistence.fetchByPrimaryKey(answerId);
    }

    /**
     * Returns the event poll answer with the primary key.
     *
     * @param answerId the primary key of the event poll answer
     * @return the event poll answer
     * @throws PortalException if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer getEventPollAnswer(long answerId)
        throws PortalException, SystemException {
        return eventPollAnswerPersistence.findByPrimaryKey(answerId);
    }

    @Override
    public PersistedModel getPersistedModel(Serializable primaryKeyObj)
        throws PortalException, SystemException {
        return eventPollAnswerPersistence.findByPrimaryKey(primaryKeyObj);
    }

    /**
     * Returns a range of all the event poll answers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of event poll answers
     * @param end the upper bound of the range of event poll answers (not inclusive)
     * @return the range of event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> getEventPollAnswers(int start, int end)
        throws SystemException {
        return eventPollAnswerPersistence.findAll(start, end);
    }

    /**
     * Returns the number of event poll answers.
     *
     * @return the number of event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int getEventPollAnswersCount() throws SystemException {
        return eventPollAnswerPersistence.countAll();
    }

    /**
     * Updates the event poll answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
     *
     * @param eventPollAnswer the event poll answer
     * @return the event poll answer that was updated
     * @throws SystemException if a system exception occurred
     */
    @Indexable(type = IndexableType.REINDEX)
    @Override
    public EventPollAnswer updateEventPollAnswer(
        EventPollAnswer eventPollAnswer) throws SystemException {
        return eventPollAnswerPersistence.update(eventPollAnswer);
    }

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

        PersistedModelLocalServiceRegistryUtil.register("com.liferay.events.global.mobile.model.EventPollAnswer",
            eventPollAnswerLocalService);
    }

    public void destroy() {
        PersistedModelLocalServiceRegistryUtil.unregister(
            "com.liferay.events.global.mobile.model.EventPollAnswer");
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