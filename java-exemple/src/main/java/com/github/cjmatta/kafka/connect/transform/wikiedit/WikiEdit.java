/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.cjmatta.kafka.connect.transform.wikiedit;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class WikiEdit extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 8420365188078653907L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"WikiEdit\",\"namespace\":\"com.github.cjmatta.kafka.connect.transform.wikiedit\",\"fields\":[{\"name\":\"createdat\",\"type\":{\"type\":\"long\",\"connect.doc\":\"The timestamp of the edit\",\"connect.version\":1,\"connect.name\":\"org.apache.kafka.connect.data.Timestamp\",\"logicalType\":\"timestamp-millis\"},\"doc\":\"The timestamp of the edit\"},{\"name\":\"wikipage\",\"type\":{\"type\":\"string\",\"connect.doc\":\"The page that was edited\"},\"doc\":\"The page that was edited\"},{\"name\":\"channel\",\"type\":{\"type\":\"string\",\"connect.doc\":\"The source channel the edit came through\"},\"doc\":\"The source channel the edit came through\"},{\"name\":\"username\",\"type\":{\"type\":\"string\",\"connect.doc\":\"Username of editor\"},\"doc\":\"Username of editor\"},{\"name\":\"commitmessage\",\"type\":{\"type\":\"string\",\"connect.doc\":\"Commit message for edit.\"},\"doc\":\"Commit message for edit.\"},{\"name\":\"bytechange\",\"type\":{\"type\":\"int\",\"connect.doc\":\"number of bytes added or removed with this edit.\"},\"doc\":\"number of bytes added or removed with this edit.\"},{\"name\":\"diffurl\",\"type\":{\"type\":\"string\",\"connect.doc\":\"The URL showing the edit diff.\"},\"doc\":\"The URL showing the edit diff.\"},{\"name\":\"isnew\",\"type\":{\"type\":\"boolean\",\"connect.doc\":\"Is this a new page?\",\"connect.default\":false},\"doc\":\"Is this a new page?\",\"default\":false},{\"name\":\"isminor\",\"type\":{\"type\":\"boolean\",\"connect.doc\":\"Is this edit minor?\",\"connect.default\":false},\"doc\":\"Is this edit minor?\",\"default\":false},{\"name\":\"isbot\",\"type\":{\"type\":\"boolean\",\"connect.doc\":\"Is this an edit by a bot?\",\"connect.default\":false},\"doc\":\"Is this an edit by a bot?\",\"default\":false},{\"name\":\"isunpatrolled\",\"type\":{\"type\":\"boolean\",\"connect.doc\":\"Is this edit unpatrolled?\",\"connect.default\":false},\"doc\":\"Is this edit unpatrolled?\",\"default\":false}],\"connect.doc\":\"The parsed Wikipedia Edit\",\"connect.name\":\"com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<WikiEdit> ENCODER =
      new BinaryMessageEncoder<WikiEdit>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<WikiEdit> DECODER =
      new BinaryMessageDecoder<WikiEdit>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<WikiEdit> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<WikiEdit> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<WikiEdit>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this WikiEdit to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a WikiEdit from a ByteBuffer. */
  public static WikiEdit fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The timestamp of the edit */
  @Deprecated public org.joda.time.DateTime createdat;
  /** The page that was edited */
  @Deprecated public java.lang.CharSequence wikipage;
  /** The source channel the edit came through */
  @Deprecated public java.lang.CharSequence channel;
  /** Username of editor */
  @Deprecated public java.lang.CharSequence username;
  /** Commit message for edit. */
  @Deprecated public java.lang.CharSequence commitmessage;
  /** number of bytes added or removed with this edit. */
  @Deprecated public int bytechange;
  /** The URL showing the edit diff. */
  @Deprecated public java.lang.CharSequence diffurl;
  /** Is this a new page? */
  @Deprecated public boolean isnew;
  /** Is this edit minor? */
  @Deprecated public boolean isminor;
  /** Is this an edit by a bot? */
  @Deprecated public boolean isbot;
  /** Is this edit unpatrolled? */
  @Deprecated public boolean isunpatrolled;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public WikiEdit() {}

  /**
   * All-args constructor.
   * @param createdat The timestamp of the edit
   * @param wikipage The page that was edited
   * @param channel The source channel the edit came through
   * @param username Username of editor
   * @param commitmessage Commit message for edit.
   * @param bytechange number of bytes added or removed with this edit.
   * @param diffurl The URL showing the edit diff.
   * @param isnew Is this a new page?
   * @param isminor Is this edit minor?
   * @param isbot Is this an edit by a bot?
   * @param isunpatrolled Is this edit unpatrolled?
   */
  public WikiEdit(org.joda.time.DateTime createdat, java.lang.CharSequence wikipage, java.lang.CharSequence channel, java.lang.CharSequence username, java.lang.CharSequence commitmessage, java.lang.Integer bytechange, java.lang.CharSequence diffurl, java.lang.Boolean isnew, java.lang.Boolean isminor, java.lang.Boolean isbot, java.lang.Boolean isunpatrolled) {
    this.createdat = createdat;
    this.wikipage = wikipage;
    this.channel = channel;
    this.username = username;
    this.commitmessage = commitmessage;
    this.bytechange = bytechange;
    this.diffurl = diffurl;
    this.isnew = isnew;
    this.isminor = isminor;
    this.isbot = isbot;
    this.isunpatrolled = isunpatrolled;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return createdat;
    case 1: return wikipage;
    case 2: return channel;
    case 3: return username;
    case 4: return commitmessage;
    case 5: return bytechange;
    case 6: return diffurl;
    case 7: return isnew;
    case 8: return isminor;
    case 9: return isbot;
    case 10: return isunpatrolled;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  protected static final org.apache.avro.data.TimeConversions.DateConversion DATE_CONVERSION = new org.apache.avro.data.TimeConversions.DateConversion();
  protected static final org.apache.avro.data.TimeConversions.TimeConversion TIME_CONVERSION = new org.apache.avro.data.TimeConversions.TimeConversion();
  protected static final org.apache.avro.data.TimeConversions.TimestampConversion TIMESTAMP_CONVERSION = new org.apache.avro.data.TimeConversions.TimestampConversion();
  protected static final org.apache.avro.Conversions.DecimalConversion DECIMAL_CONVERSION = new org.apache.avro.Conversions.DecimalConversion();

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
      TIMESTAMP_CONVERSION,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
  };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: createdat = (org.joda.time.DateTime)value$; break;
    case 1: wikipage = (java.lang.CharSequence)value$; break;
    case 2: channel = (java.lang.CharSequence)value$; break;
    case 3: username = (java.lang.CharSequence)value$; break;
    case 4: commitmessage = (java.lang.CharSequence)value$; break;
    case 5: bytechange = (java.lang.Integer)value$; break;
    case 6: diffurl = (java.lang.CharSequence)value$; break;
    case 7: isnew = (java.lang.Boolean)value$; break;
    case 8: isminor = (java.lang.Boolean)value$; break;
    case 9: isbot = (java.lang.Boolean)value$; break;
    case 10: isunpatrolled = (java.lang.Boolean)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'createdat' field.
   * @return The timestamp of the edit
   */
  public org.joda.time.DateTime getCreatedat() {
    return createdat;
  }

  /**
   * Sets the value of the 'createdat' field.
   * The timestamp of the edit
   * @param value the value to set.
   */
  public void setCreatedat(org.joda.time.DateTime value) {
    this.createdat = value;
  }

  /**
   * Gets the value of the 'wikipage' field.
   * @return The page that was edited
   */
  public java.lang.CharSequence getWikipage() {
    return wikipage;
  }

  /**
   * Sets the value of the 'wikipage' field.
   * The page that was edited
   * @param value the value to set.
   */
  public void setWikipage(java.lang.CharSequence value) {
    this.wikipage = value;
  }

  /**
   * Gets the value of the 'channel' field.
   * @return The source channel the edit came through
   */
  public java.lang.CharSequence getChannel() {
    return channel;
  }

  /**
   * Sets the value of the 'channel' field.
   * The source channel the edit came through
   * @param value the value to set.
   */
  public void setChannel(java.lang.CharSequence value) {
    this.channel = value;
  }

  /**
   * Gets the value of the 'username' field.
   * @return Username of editor
   */
  public java.lang.CharSequence getUsername() {
    return username;
  }

  /**
   * Sets the value of the 'username' field.
   * Username of editor
   * @param value the value to set.
   */
  public void setUsername(java.lang.CharSequence value) {
    this.username = value;
  }

  /**
   * Gets the value of the 'commitmessage' field.
   * @return Commit message for edit.
   */
  public java.lang.CharSequence getCommitmessage() {
    return commitmessage;
  }

  /**
   * Sets the value of the 'commitmessage' field.
   * Commit message for edit.
   * @param value the value to set.
   */
  public void setCommitmessage(java.lang.CharSequence value) {
    this.commitmessage = value;
  }

  /**
   * Gets the value of the 'bytechange' field.
   * @return number of bytes added or removed with this edit.
   */
  public java.lang.Integer getBytechange() {
    return bytechange;
  }

  /**
   * Sets the value of the 'bytechange' field.
   * number of bytes added or removed with this edit.
   * @param value the value to set.
   */
  public void setBytechange(java.lang.Integer value) {
    this.bytechange = value;
  }

  /**
   * Gets the value of the 'diffurl' field.
   * @return The URL showing the edit diff.
   */
  public java.lang.CharSequence getDiffurl() {
    return diffurl;
  }

  /**
   * Sets the value of the 'diffurl' field.
   * The URL showing the edit diff.
   * @param value the value to set.
   */
  public void setDiffurl(java.lang.CharSequence value) {
    this.diffurl = value;
  }

  /**
   * Gets the value of the 'isnew' field.
   * @return Is this a new page?
   */
  public java.lang.Boolean getIsnew() {
    return isnew;
  }

  /**
   * Sets the value of the 'isnew' field.
   * Is this a new page?
   * @param value the value to set.
   */
  public void setIsnew(java.lang.Boolean value) {
    this.isnew = value;
  }

  /**
   * Gets the value of the 'isminor' field.
   * @return Is this edit minor?
   */
  public java.lang.Boolean getIsminor() {
    return isminor;
  }

  /**
   * Sets the value of the 'isminor' field.
   * Is this edit minor?
   * @param value the value to set.
   */
  public void setIsminor(java.lang.Boolean value) {
    this.isminor = value;
  }

  /**
   * Gets the value of the 'isbot' field.
   * @return Is this an edit by a bot?
   */
  public java.lang.Boolean getIsbot() {
    return isbot;
  }

  /**
   * Sets the value of the 'isbot' field.
   * Is this an edit by a bot?
   * @param value the value to set.
   */
  public void setIsbot(java.lang.Boolean value) {
    this.isbot = value;
  }

  /**
   * Gets the value of the 'isunpatrolled' field.
   * @return Is this edit unpatrolled?
   */
  public java.lang.Boolean getIsunpatrolled() {
    return isunpatrolled;
  }

  /**
   * Sets the value of the 'isunpatrolled' field.
   * Is this edit unpatrolled?
   * @param value the value to set.
   */
  public void setIsunpatrolled(java.lang.Boolean value) {
    this.isunpatrolled = value;
  }

  /**
   * Creates a new WikiEdit RecordBuilder.
   * @return A new WikiEdit RecordBuilder
   */
  public static com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder newBuilder() {
    return new com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder();
  }

  /**
   * Creates a new WikiEdit RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new WikiEdit RecordBuilder
   */
  public static com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder newBuilder(com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder other) {
    return new com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder(other);
  }

  /**
   * Creates a new WikiEdit RecordBuilder by copying an existing WikiEdit instance.
   * @param other The existing instance to copy.
   * @return A new WikiEdit RecordBuilder
   */
  public static com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder newBuilder(com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit other) {
    return new com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder(other);
  }

  /**
   * RecordBuilder for WikiEdit instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<WikiEdit>
    implements org.apache.avro.data.RecordBuilder<WikiEdit> {

    /** The timestamp of the edit */
    private org.joda.time.DateTime createdat;
    /** The page that was edited */
    private java.lang.CharSequence wikipage;
    /** The source channel the edit came through */
    private java.lang.CharSequence channel;
    /** Username of editor */
    private java.lang.CharSequence username;
    /** Commit message for edit. */
    private java.lang.CharSequence commitmessage;
    /** number of bytes added or removed with this edit. */
    private int bytechange;
    /** The URL showing the edit diff. */
    private java.lang.CharSequence diffurl;
    /** Is this a new page? */
    private boolean isnew;
    /** Is this edit minor? */
    private boolean isminor;
    /** Is this an edit by a bot? */
    private boolean isbot;
    /** Is this edit unpatrolled? */
    private boolean isunpatrolled;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.createdat)) {
        this.createdat = data().deepCopy(fields()[0].schema(), other.createdat);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.wikipage)) {
        this.wikipage = data().deepCopy(fields()[1].schema(), other.wikipage);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.channel)) {
        this.channel = data().deepCopy(fields()[2].schema(), other.channel);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.username)) {
        this.username = data().deepCopy(fields()[3].schema(), other.username);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.commitmessage)) {
        this.commitmessage = data().deepCopy(fields()[4].schema(), other.commitmessage);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.bytechange)) {
        this.bytechange = data().deepCopy(fields()[5].schema(), other.bytechange);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.diffurl)) {
        this.diffurl = data().deepCopy(fields()[6].schema(), other.diffurl);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isnew)) {
        this.isnew = data().deepCopy(fields()[7].schema(), other.isnew);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.isminor)) {
        this.isminor = data().deepCopy(fields()[8].schema(), other.isminor);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.isbot)) {
        this.isbot = data().deepCopy(fields()[9].schema(), other.isbot);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.isunpatrolled)) {
        this.isunpatrolled = data().deepCopy(fields()[10].schema(), other.isunpatrolled);
        fieldSetFlags()[10] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing WikiEdit instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.createdat)) {
        this.createdat = data().deepCopy(fields()[0].schema(), other.createdat);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.wikipage)) {
        this.wikipage = data().deepCopy(fields()[1].schema(), other.wikipage);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.channel)) {
        this.channel = data().deepCopy(fields()[2].schema(), other.channel);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.username)) {
        this.username = data().deepCopy(fields()[3].schema(), other.username);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.commitmessage)) {
        this.commitmessage = data().deepCopy(fields()[4].schema(), other.commitmessage);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.bytechange)) {
        this.bytechange = data().deepCopy(fields()[5].schema(), other.bytechange);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.diffurl)) {
        this.diffurl = data().deepCopy(fields()[6].schema(), other.diffurl);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.isnew)) {
        this.isnew = data().deepCopy(fields()[7].schema(), other.isnew);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.isminor)) {
        this.isminor = data().deepCopy(fields()[8].schema(), other.isminor);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.isbot)) {
        this.isbot = data().deepCopy(fields()[9].schema(), other.isbot);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.isunpatrolled)) {
        this.isunpatrolled = data().deepCopy(fields()[10].schema(), other.isunpatrolled);
        fieldSetFlags()[10] = true;
      }
    }

    /**
      * Gets the value of the 'createdat' field.
      * The timestamp of the edit
      * @return The value.
      */
    public org.joda.time.DateTime getCreatedat() {
      return createdat;
    }

    /**
      * Sets the value of the 'createdat' field.
      * The timestamp of the edit
      * @param value The value of 'createdat'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setCreatedat(org.joda.time.DateTime value) {
      validate(fields()[0], value);
      this.createdat = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'createdat' field has been set.
      * The timestamp of the edit
      * @return True if the 'createdat' field has been set, false otherwise.
      */
    public boolean hasCreatedat() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'createdat' field.
      * The timestamp of the edit
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearCreatedat() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'wikipage' field.
      * The page that was edited
      * @return The value.
      */
    public java.lang.CharSequence getWikipage() {
      return wikipage;
    }

    /**
      * Sets the value of the 'wikipage' field.
      * The page that was edited
      * @param value The value of 'wikipage'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setWikipage(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.wikipage = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'wikipage' field has been set.
      * The page that was edited
      * @return True if the 'wikipage' field has been set, false otherwise.
      */
    public boolean hasWikipage() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'wikipage' field.
      * The page that was edited
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearWikipage() {
      wikipage = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'channel' field.
      * The source channel the edit came through
      * @return The value.
      */
    public java.lang.CharSequence getChannel() {
      return channel;
    }

    /**
      * Sets the value of the 'channel' field.
      * The source channel the edit came through
      * @param value The value of 'channel'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setChannel(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.channel = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'channel' field has been set.
      * The source channel the edit came through
      * @return True if the 'channel' field has been set, false otherwise.
      */
    public boolean hasChannel() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'channel' field.
      * The source channel the edit came through
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearChannel() {
      channel = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'username' field.
      * Username of editor
      * @return The value.
      */
    public java.lang.CharSequence getUsername() {
      return username;
    }

    /**
      * Sets the value of the 'username' field.
      * Username of editor
      * @param value The value of 'username'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setUsername(java.lang.CharSequence value) {
      validate(fields()[3], value);
      this.username = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'username' field has been set.
      * Username of editor
      * @return True if the 'username' field has been set, false otherwise.
      */
    public boolean hasUsername() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'username' field.
      * Username of editor
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearUsername() {
      username = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'commitmessage' field.
      * Commit message for edit.
      * @return The value.
      */
    public java.lang.CharSequence getCommitmessage() {
      return commitmessage;
    }

    /**
      * Sets the value of the 'commitmessage' field.
      * Commit message for edit.
      * @param value The value of 'commitmessage'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setCommitmessage(java.lang.CharSequence value) {
      validate(fields()[4], value);
      this.commitmessage = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'commitmessage' field has been set.
      * Commit message for edit.
      * @return True if the 'commitmessage' field has been set, false otherwise.
      */
    public boolean hasCommitmessage() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'commitmessage' field.
      * Commit message for edit.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearCommitmessage() {
      commitmessage = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'bytechange' field.
      * number of bytes added or removed with this edit.
      * @return The value.
      */
    public java.lang.Integer getBytechange() {
      return bytechange;
    }

    /**
      * Sets the value of the 'bytechange' field.
      * number of bytes added or removed with this edit.
      * @param value The value of 'bytechange'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setBytechange(int value) {
      validate(fields()[5], value);
      this.bytechange = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'bytechange' field has been set.
      * number of bytes added or removed with this edit.
      * @return True if the 'bytechange' field has been set, false otherwise.
      */
    public boolean hasBytechange() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'bytechange' field.
      * number of bytes added or removed with this edit.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearBytechange() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'diffurl' field.
      * The URL showing the edit diff.
      * @return The value.
      */
    public java.lang.CharSequence getDiffurl() {
      return diffurl;
    }

    /**
      * Sets the value of the 'diffurl' field.
      * The URL showing the edit diff.
      * @param value The value of 'diffurl'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setDiffurl(java.lang.CharSequence value) {
      validate(fields()[6], value);
      this.diffurl = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'diffurl' field has been set.
      * The URL showing the edit diff.
      * @return True if the 'diffurl' field has been set, false otherwise.
      */
    public boolean hasDiffurl() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'diffurl' field.
      * The URL showing the edit diff.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearDiffurl() {
      diffurl = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'isnew' field.
      * Is this a new page?
      * @return The value.
      */
    public java.lang.Boolean getIsnew() {
      return isnew;
    }

    /**
      * Sets the value of the 'isnew' field.
      * Is this a new page?
      * @param value The value of 'isnew'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setIsnew(boolean value) {
      validate(fields()[7], value);
      this.isnew = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'isnew' field has been set.
      * Is this a new page?
      * @return True if the 'isnew' field has been set, false otherwise.
      */
    public boolean hasIsnew() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'isnew' field.
      * Is this a new page?
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearIsnew() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'isminor' field.
      * Is this edit minor?
      * @return The value.
      */
    public java.lang.Boolean getIsminor() {
      return isminor;
    }

    /**
      * Sets the value of the 'isminor' field.
      * Is this edit minor?
      * @param value The value of 'isminor'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setIsminor(boolean value) {
      validate(fields()[8], value);
      this.isminor = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'isminor' field has been set.
      * Is this edit minor?
      * @return True if the 'isminor' field has been set, false otherwise.
      */
    public boolean hasIsminor() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'isminor' field.
      * Is this edit minor?
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearIsminor() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'isbot' field.
      * Is this an edit by a bot?
      * @return The value.
      */
    public java.lang.Boolean getIsbot() {
      return isbot;
    }

    /**
      * Sets the value of the 'isbot' field.
      * Is this an edit by a bot?
      * @param value The value of 'isbot'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setIsbot(boolean value) {
      validate(fields()[9], value);
      this.isbot = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'isbot' field has been set.
      * Is this an edit by a bot?
      * @return True if the 'isbot' field has been set, false otherwise.
      */
    public boolean hasIsbot() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'isbot' field.
      * Is this an edit by a bot?
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearIsbot() {
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'isunpatrolled' field.
      * Is this edit unpatrolled?
      * @return The value.
      */
    public java.lang.Boolean getIsunpatrolled() {
      return isunpatrolled;
    }

    /**
      * Sets the value of the 'isunpatrolled' field.
      * Is this edit unpatrolled?
      * @param value The value of 'isunpatrolled'.
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder setIsunpatrolled(boolean value) {
      validate(fields()[10], value);
      this.isunpatrolled = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'isunpatrolled' field has been set.
      * Is this edit unpatrolled?
      * @return True if the 'isunpatrolled' field has been set, false otherwise.
      */
    public boolean hasIsunpatrolled() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'isunpatrolled' field.
      * Is this edit unpatrolled?
      * @return This builder.
      */
    public com.github.cjmatta.kafka.connect.transform.wikiedit.WikiEdit.Builder clearIsunpatrolled() {
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public WikiEdit build() {
      try {
        WikiEdit record = new WikiEdit();
        record.createdat = fieldSetFlags()[0] ? this.createdat : (org.joda.time.DateTime) defaultValue(fields()[0], record.getConversion(0));
        record.wikipage = fieldSetFlags()[1] ? this.wikipage : (java.lang.CharSequence) defaultValue(fields()[1], record.getConversion(1));
        record.channel = fieldSetFlags()[2] ? this.channel : (java.lang.CharSequence) defaultValue(fields()[2], record.getConversion(2));
        record.username = fieldSetFlags()[3] ? this.username : (java.lang.CharSequence) defaultValue(fields()[3], record.getConversion(3));
        record.commitmessage = fieldSetFlags()[4] ? this.commitmessage : (java.lang.CharSequence) defaultValue(fields()[4], record.getConversion(4));
        record.bytechange = fieldSetFlags()[5] ? this.bytechange : (java.lang.Integer) defaultValue(fields()[5], record.getConversion(5));
        record.diffurl = fieldSetFlags()[6] ? this.diffurl : (java.lang.CharSequence) defaultValue(fields()[6], record.getConversion(6));
        record.isnew = fieldSetFlags()[7] ? this.isnew : (java.lang.Boolean) defaultValue(fields()[7], record.getConversion(7));
        record.isminor = fieldSetFlags()[8] ? this.isminor : (java.lang.Boolean) defaultValue(fields()[8], record.getConversion(8));
        record.isbot = fieldSetFlags()[9] ? this.isbot : (java.lang.Boolean) defaultValue(fields()[9], record.getConversion(9));
        record.isunpatrolled = fieldSetFlags()[10] ? this.isunpatrolled : (java.lang.Boolean) defaultValue(fields()[10], record.getConversion(10));
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<WikiEdit>
    WRITER$ = (org.apache.avro.io.DatumWriter<WikiEdit>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<WikiEdit>
    READER$ = (org.apache.avro.io.DatumReader<WikiEdit>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
