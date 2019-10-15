/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package fortune;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-10-15")
public class VehicleDescription extends org.apache.thrift.TUnion<VehicleDescription, VehicleDescription._Fields> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("VehicleDescription");
  private static final org.apache.thrift.protocol.TField CAR_NICKNAME_FIELD_DESC = new org.apache.thrift.protocol.TField("car_nickname", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField BIKE_FRAME_SIZE_CM_FIELD_DESC = new org.apache.thrift.protocol.TField("bike_frame_size_cm", org.apache.thrift.protocol.TType.I32, (short)2);

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    CAR_NICKNAME((short)1, "car_nickname"),
    BIKE_FRAME_SIZE_CM((short)2, "bike_frame_size_cm");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CAR_NICKNAME
          return CAR_NICKNAME;
        case 2: // BIKE_FRAME_SIZE_CM
          return BIKE_FRAME_SIZE_CM;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CAR_NICKNAME, new org.apache.thrift.meta_data.FieldMetaData("car_nickname", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.BIKE_FRAME_SIZE_CM, new org.apache.thrift.meta_data.FieldMetaData("bike_frame_size_cm", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(VehicleDescription.class, metaDataMap);
  }

  public VehicleDescription() {
    super();
  }

  public VehicleDescription(_Fields setField, java.lang.Object value) {
    super(setField, value);
  }

  public VehicleDescription(VehicleDescription other) {
    super(other);
  }
  public VehicleDescription deepCopy() {
    return new VehicleDescription(this);
  }

  public static VehicleDescription car_nickname(java.lang.String value) {
    VehicleDescription x = new VehicleDescription();
    x.setCar_nickname(value);
    return x;
  }

  public static VehicleDescription bike_frame_size_cm(int value) {
    VehicleDescription x = new VehicleDescription();
    x.setBike_frame_size_cm(value);
    return x;
  }


  @Override
  protected void checkType(_Fields setField, java.lang.Object value) throws java.lang.ClassCastException {
    switch (setField) {
      case CAR_NICKNAME:
        if (value instanceof java.lang.String) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.String for field 'car_nickname', but got " + value.getClass().getSimpleName());
      case BIKE_FRAME_SIZE_CM:
        if (value instanceof java.lang.Integer) {
          break;
        }
        throw new java.lang.ClassCastException("Was expecting value of type java.lang.Integer for field 'bike_frame_size_cm', but got " + value.getClass().getSimpleName());
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected java.lang.Object standardSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TField field) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(field.id);
    if (setField != null) {
      switch (setField) {
        case CAR_NICKNAME:
          if (field.type == CAR_NICKNAME_FIELD_DESC.type) {
            java.lang.String car_nickname;
            car_nickname = iprot.readString();
            return car_nickname;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        case BIKE_FRAME_SIZE_CM:
          if (field.type == BIKE_FRAME_SIZE_CM_FIELD_DESC.type) {
            java.lang.Integer bike_frame_size_cm;
            bike_frame_size_cm = iprot.readI32();
            return bike_frame_size_cm;
          } else {
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
            return null;
          }
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      return null;
    }
  }

  @Override
  protected void standardSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case CAR_NICKNAME:
        java.lang.String car_nickname = (java.lang.String)value_;
        oprot.writeString(car_nickname);
        return;
      case BIKE_FRAME_SIZE_CM:
        java.lang.Integer bike_frame_size_cm = (java.lang.Integer)value_;
        oprot.writeI32(bike_frame_size_cm);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected java.lang.Object tupleSchemeReadValue(org.apache.thrift.protocol.TProtocol iprot, short fieldID) throws org.apache.thrift.TException {
    _Fields setField = _Fields.findByThriftId(fieldID);
    if (setField != null) {
      switch (setField) {
        case CAR_NICKNAME:
          java.lang.String car_nickname;
          car_nickname = iprot.readString();
          return car_nickname;
        case BIKE_FRAME_SIZE_CM:
          java.lang.Integer bike_frame_size_cm;
          bike_frame_size_cm = iprot.readI32();
          return bike_frame_size_cm;
        default:
          throw new java.lang.IllegalStateException("setField wasn't null, but didn't match any of the case statements!");
      }
    } else {
      throw new org.apache.thrift.protocol.TProtocolException("Couldn't find a field with field id " + fieldID);
    }
  }

  @Override
  protected void tupleSchemeWriteValue(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    switch (setField_) {
      case CAR_NICKNAME:
        java.lang.String car_nickname = (java.lang.String)value_;
        oprot.writeString(car_nickname);
        return;
      case BIKE_FRAME_SIZE_CM:
        java.lang.Integer bike_frame_size_cm = (java.lang.Integer)value_;
        oprot.writeI32(bike_frame_size_cm);
        return;
      default:
        throw new java.lang.IllegalStateException("Cannot write union with unknown field " + setField_);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TField getFieldDesc(_Fields setField) {
    switch (setField) {
      case CAR_NICKNAME:
        return CAR_NICKNAME_FIELD_DESC;
      case BIKE_FRAME_SIZE_CM:
        return BIKE_FRAME_SIZE_CM_FIELD_DESC;
      default:
        throw new java.lang.IllegalArgumentException("Unknown field id " + setField);
    }
  }

  @Override
  protected org.apache.thrift.protocol.TStruct getStructDesc() {
    return STRUCT_DESC;
  }

  @Override
  protected _Fields enumForId(short id) {
    return _Fields.findByThriftIdOrThrow(id);
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }


  public java.lang.String getCar_nickname() {
    if (getSetField() == _Fields.CAR_NICKNAME) {
      return (java.lang.String)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'car_nickname' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setCar_nickname(java.lang.String value) {
    if (value == null) throw new java.lang.NullPointerException();
    setField_ = _Fields.CAR_NICKNAME;
    value_ = value;
  }

  public int getBike_frame_size_cm() {
    if (getSetField() == _Fields.BIKE_FRAME_SIZE_CM) {
      return (java.lang.Integer)getFieldValue();
    } else {
      throw new java.lang.RuntimeException("Cannot get field 'bike_frame_size_cm' because union is currently set to " + getFieldDesc(getSetField()).name);
    }
  }

  public void setBike_frame_size_cm(int value) {
    setField_ = _Fields.BIKE_FRAME_SIZE_CM;
    value_ = value;
  }

  public boolean isSetCar_nickname() {
    return setField_ == _Fields.CAR_NICKNAME;
  }


  public boolean isSetBike_frame_size_cm() {
    return setField_ == _Fields.BIKE_FRAME_SIZE_CM;
  }


  public boolean equals(java.lang.Object other) {
    if (other instanceof VehicleDescription) {
      return equals((VehicleDescription)other);
    } else {
      return false;
    }
  }

  public boolean equals(VehicleDescription other) {
    return other != null && getSetField() == other.getSetField() && getFieldValue().equals(other.getFieldValue());
  }

  @Override
  public int compareTo(VehicleDescription other) {
    int lastComparison = org.apache.thrift.TBaseHelper.compareTo(getSetField(), other.getSetField());
    if (lastComparison == 0) {
      return org.apache.thrift.TBaseHelper.compareTo(getFieldValue(), other.getFieldValue());
    }
    return lastComparison;
  }


  @Override
  public int hashCode() {
    java.util.List<java.lang.Object> list = new java.util.ArrayList<java.lang.Object>();
    list.add(this.getClass().getName());
    org.apache.thrift.TFieldIdEnum setField = getSetField();
    if (setField != null) {
      list.add(setField.getThriftFieldId());
      java.lang.Object value = getFieldValue();
      if (value instanceof org.apache.thrift.TEnum) {
        list.add(((org.apache.thrift.TEnum)getFieldValue()).getValue());
      } else {
        list.add(value);
      }
    }
    return list.hashCode();
  }
  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }


}
