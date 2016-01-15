package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.Match;
import com.liferay.events.global.mobile.model.MatchModel;
import com.liferay.events.global.mobile.model.MatchSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Match service. Represents a row in the &quot;Matcher_Match&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.events.global.mobile.model.MatchModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MatchImpl}.
 * </p>
 *
 * @author James Falkner
 * @see MatchImpl
 * @see com.liferay.events.global.mobile.model.Match
 * @see com.liferay.events.global.mobile.model.MatchModel
 * @generated
 */
@JSON(strict = true)
public class MatchModelImpl extends BaseModelImpl<Match> implements MatchModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a match model instance should use the {@link com.liferay.events.global.mobile.model.Match} interface instead.
     */
    public static final String TABLE_NAME = "Matcher_Match";
    public static final Object[][] TABLE_COLUMNS = {
            { "contactId1", Types.BIGINT },
            { "contactId2", Types.BIGINT },
            { "eventId", Types.VARCHAR },
            { "matchId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "userName", Types.VARCHAR },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table Matcher_Match (contactId1 LONG,contactId2 LONG,eventId VARCHAR(75) null,matchId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
    public static final String TABLE_SQL_DROP = "drop table Matcher_Match";
    public static final String ORDER_BY_JPQL = " ORDER BY match.matchId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY Matcher_Match.matchId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.liferay.events.global.mobile.model.Match"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.liferay.events.global.mobile.model.Match"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.liferay.events.global.mobile.model.Match"),
            true);
    public static long CONTACTID1_COLUMN_BITMASK = 1L;
    public static long CONTACTID2_COLUMN_BITMASK = 2L;
    public static long EVENTID_COLUMN_BITMASK = 4L;
    public static long MATCHID_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.liferay.events.global.mobile.model.Match"));
    private static ClassLoader _classLoader = Match.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Match.class };
    private long _contactId1;
    private long _originalContactId1;
    private boolean _setOriginalContactId1;
    private long _contactId2;
    private long _originalContactId2;
    private boolean _setOriginalContactId2;
    private String _eventId;
    private String _originalEventId;
    private long _matchId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private long _columnBitmask;
    private Match _escapedModel;

    public MatchModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static Match toModel(MatchSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        Match model = new MatchImpl();

        model.setContactId1(soapModel.getContactId1());
        model.setContactId2(soapModel.getContactId2());
        model.setEventId(soapModel.getEventId());
        model.setMatchId(soapModel.getMatchId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());
        model.setUserId(soapModel.getUserId());
        model.setUserName(soapModel.getUserName());
        model.setCreateDate(soapModel.getCreateDate());
        model.setModifiedDate(soapModel.getModifiedDate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<Match> toModels(MatchSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<Match> models = new ArrayList<Match>(soapModels.length);

        for (MatchSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _matchId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMatchId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _matchId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Match.class;
    }

    @Override
    public String getModelClassName() {
        return Match.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contactId1", getContactId1());
        attributes.put("contactId2", getContactId2());
        attributes.put("eventId", getEventId());
        attributes.put("matchId", getMatchId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long contactId1 = (Long) attributes.get("contactId1");

        if (contactId1 != null) {
            setContactId1(contactId1);
        }

        Long contactId2 = (Long) attributes.get("contactId2");

        if (contactId2 != null) {
            setContactId2(contactId2);
        }

        String eventId = (String) attributes.get("eventId");

        if (eventId != null) {
            setEventId(eventId);
        }

        Long matchId = (Long) attributes.get("matchId");

        if (matchId != null) {
            setMatchId(matchId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }
    }

    @JSON
    @Override
    public long getContactId1() {
        return _contactId1;
    }

    @Override
    public void setContactId1(long contactId1) {
        _columnBitmask |= CONTACTID1_COLUMN_BITMASK;

        if (!_setOriginalContactId1) {
            _setOriginalContactId1 = true;

            _originalContactId1 = _contactId1;
        }

        _contactId1 = contactId1;
    }

    public long getOriginalContactId1() {
        return _originalContactId1;
    }

    @JSON
    @Override
    public long getContactId2() {
        return _contactId2;
    }

    @Override
    public void setContactId2(long contactId2) {
        _columnBitmask |= CONTACTID2_COLUMN_BITMASK;

        if (!_setOriginalContactId2) {
            _setOriginalContactId2 = true;

            _originalContactId2 = _contactId2;
        }

        _contactId2 = contactId2;
    }

    public long getOriginalContactId2() {
        return _originalContactId2;
    }

    @JSON
    @Override
    public String getEventId() {
        if (_eventId == null) {
            return StringPool.BLANK;
        } else {
            return _eventId;
        }
    }

    @Override
    public void setEventId(String eventId) {
        _columnBitmask |= EVENTID_COLUMN_BITMASK;

        if (_originalEventId == null) {
            _originalEventId = _eventId;
        }

        _eventId = eventId;
    }

    public String getOriginalEventId() {
        return GetterUtil.getString(_originalEventId);
    }

    @JSON
    @Override
    public long getMatchId() {
        return _matchId;
    }

    @Override
    public void setMatchId(long matchId) {
        _matchId = matchId;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @JSON
    @Override
    public String getUserName() {
        if (_userName == null) {
            return StringPool.BLANK;
        } else {
            return _userName;
        }
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;
    }

    @JSON
    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @JSON
    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Match.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Match toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Match) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        MatchImpl matchImpl = new MatchImpl();

        matchImpl.setContactId1(getContactId1());
        matchImpl.setContactId2(getContactId2());
        matchImpl.setEventId(getEventId());
        matchImpl.setMatchId(getMatchId());
        matchImpl.setGroupId(getGroupId());
        matchImpl.setCompanyId(getCompanyId());
        matchImpl.setUserId(getUserId());
        matchImpl.setUserName(getUserName());
        matchImpl.setCreateDate(getCreateDate());
        matchImpl.setModifiedDate(getModifiedDate());

        matchImpl.resetOriginalValues();

        return matchImpl;
    }

    @Override
    public int compareTo(Match match) {
        long primaryKey = match.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Match)) {
            return false;
        }

        Match match = (Match) obj;

        long primaryKey = match.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        MatchModelImpl matchModelImpl = this;

        matchModelImpl._originalContactId1 = matchModelImpl._contactId1;

        matchModelImpl._setOriginalContactId1 = false;

        matchModelImpl._originalContactId2 = matchModelImpl._contactId2;

        matchModelImpl._setOriginalContactId2 = false;

        matchModelImpl._originalEventId = matchModelImpl._eventId;

        matchModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Match> toCacheModel() {
        MatchCacheModel matchCacheModel = new MatchCacheModel();

        matchCacheModel.contactId1 = getContactId1();

        matchCacheModel.contactId2 = getContactId2();

        matchCacheModel.eventId = getEventId();

        String eventId = matchCacheModel.eventId;

        if ((eventId != null) && (eventId.length() == 0)) {
            matchCacheModel.eventId = null;
        }

        matchCacheModel.matchId = getMatchId();

        matchCacheModel.groupId = getGroupId();

        matchCacheModel.companyId = getCompanyId();

        matchCacheModel.userId = getUserId();

        matchCacheModel.userName = getUserName();

        String userName = matchCacheModel.userName;

        if ((userName != null) && (userName.length() == 0)) {
            matchCacheModel.userName = null;
        }

        Date createDate = getCreateDate();

        if (createDate != null) {
            matchCacheModel.createDate = createDate.getTime();
        } else {
            matchCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            matchCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            matchCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        return matchCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{contactId1=");
        sb.append(getContactId1());
        sb.append(", contactId2=");
        sb.append(getContactId2());
        sb.append(", eventId=");
        sb.append(getEventId());
        sb.append(", matchId=");
        sb.append(getMatchId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.liferay.events.global.mobile.model.Match");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contactId1</column-name><column-value><![CDATA[");
        sb.append(getContactId1());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactId2</column-name><column-value><![CDATA[");
        sb.append(getContactId2());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>eventId</column-name><column-value><![CDATA[");
        sb.append(getEventId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>matchId</column-name><column-value><![CDATA[");
        sb.append(getMatchId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}