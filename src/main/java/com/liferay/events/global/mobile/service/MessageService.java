package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for Message. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author James Falkner
 * @see MessageServiceUtil
 * @see com.liferay.events.global.mobile.service.base.MessageServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.MessageServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MessageService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MessageServiceUtil} to access the message remote service. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.MessageServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.liferay.events.global.mobile.model.Message sendMessage(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String message, java.lang.String signature)
        throws java.lang.Exception;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.events.global.mobile.model.Message> getMessages(
        java.lang.String eventId, long contactId, long beginDate,
        java.lang.String signature) throws java.lang.Exception;
}
