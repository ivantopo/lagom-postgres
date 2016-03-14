/*
* Created by DSL Platform
* v1.5.5912.31151
*/

package worldwonders.model;

public class Wonder implements java.lang.Cloneable, java.io.Serializable, org.revenj.patterns.AggregateRoot,
        com.dslplatform.json.JsonObject {
    public Wonder() {
        URI = java.lang.Integer.toString(System.identityHashCode(this));
        this.nativeNames = new java.util.ArrayList<String>(4);
        this.englishName = "";
        this.isAncient = false;
        this.ratings = new java.util.ArrayList<worldwonders.model.Rating>(4);
    }

    private String URI;

    public String getURI() {
        return this.URI;
    }

    @Override
    public int hashCode() {
        return URI.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || obj instanceof Wonder == false) return false;
        final Wonder other = (Wonder) obj;
        return URI.equals(other.URI);
    }

    public boolean deepEquals(final Wonder other) {
        if (this == other) return true;
        if (other == null) return false;
        if (!URI.equals(other.URI)) return false;

        if (!((this.nativeNames == other.nativeNames || this.nativeNames != null
                && this.nativeNames.equals(other.nativeNames)))) return false;
        if (!(this.englishName.equals(other.englishName))) return false;
        if (!(this.isAncient == other.isAncient)) return false;
        if (!(this.imageLink == other.imageLink || this.imageLink != null && this.imageLink.equals(other.imageLink)))
            return false;
        if (!(java.util.Arrays.equals(this.ratingsURI, other.ratingsURI))) return false;
        return true;
    }

    private Wonder(Wonder other) {
        this.URI = other.URI;
        this.__locator = other.__locator;
        this.nativeNames = new java.util.ArrayList<String>(other.nativeNames);
        this.englishName = other.englishName;
        this.isAncient = other.isAncient;
        this.imageLink = other.imageLink;
        this.ratingsURI = other.getRatingsURI();
        this.__originalValue = other.__originalValue;
    }

    @Override
    public Object clone() {
        return new Wonder(this);
    }

    @Override
    public String toString() {
        return "Wonder(" + URI + ')';
    }

    public Wonder(
            final java.util.List<String> nativeNames,
            final String englishName,
            final boolean isAncient,
            final java.net.URI imageLink,
            final java.util.List<worldwonders.model.Rating> ratings) {
        setNativeNames(nativeNames);
        setEnglishName(englishName);
        setIsAncient(isAncient);
        setImageLink(imageLink);
        setRatings(ratings);
        this.URI = this.englishName;
    }

    private transient java.util.Optional<org.revenj.patterns.ServiceLocator> __locator = java.util.Optional.empty();
    private static final long serialVersionUID = 621893023363132312L;

    private java.util.List<String> nativeNames;

    public java.util.List<String> getNativeNames() {
        return nativeNames;
    }

    public Wonder setNativeNames(final java.util.List<String> value) {
        if (value == null) throw new IllegalArgumentException("Property \"nativeNames\" cannot be null!");
        org.revenj.Guards.checkNulls(value);
        this.nativeNames = value;

        return this;
    }

    private String englishName;

    public String getEnglishName() {
        return englishName;
    }

    public Wonder setEnglishName(final String value) {
        if (value == null) throw new IllegalArgumentException("Property \"englishName\" cannot be null!");
        this.englishName = value;

        return this;
    }

    private boolean isAncient;

    public boolean getIsAncient() {
        return isAncient;
    }

    public Wonder setIsAncient(final boolean value) {
        this.isAncient = value;

        return this;
    }

    private java.net.URI imageLink;

    public java.net.URI getImageLink() {
        return imageLink;
    }

    public Wonder setImageLink(final java.net.URI value) {
        this.imageLink = value;

        return this;
    }

    private static final String[] _defaultratingsURI = new String[0];

    private java.util.List<worldwonders.model.Rating> ratings;

    public java.util.List<worldwonders.model.Rating> getRatings() {
        if (this.ratingsURI != null && this.ratingsURI.length == 0) {
            this.ratings = new java.util.ArrayList<worldwonders.model.Rating>(4);
            this.ratingsURI = null;
        }

        if (this.__locator.isPresent()
                && (this.ratingsURI != null && (this.ratings == null || this.ratings.size() != this.ratingsURI.length))) {
            worldwonders.model.repositories.RatingRepository repository = this.__locator.get().resolve(
                    worldwonders.model.repositories.RatingRepository.class);
            java.util.List<worldwonders.model.Rating> __list = repository.find(this.ratingsURI);
            ratings = __list;
            this.ratingsURI = null;
        }
        return ratings;
    }

    public Wonder setRatings(final java.util.List<worldwonders.model.Rating> value) {
        if (value == null) throw new IllegalArgumentException("Property \"ratings\" cannot be null!");
        org.revenj.Guards.checkNulls(value);

        if (value != null) {
            for (final worldwonders.model.Rating refEnt : value)
                if (refEnt == null || refEnt.getURI() == null)
                    throw new IllegalArgumentException(
                            "Reference \"model.Rating\" for property \"ratings\" must be persisted before it's assigned");
        }
        this.ratings = value;

        this.ratingsURI = null;
        return this;
    }

    private String[] ratingsURI;

    public String[] getRatingsURI() {
        if (this.ratings != null) {
            final String[] _result = new String[this.ratings.size()];
            int _i = 0;
            for (final worldwonders.model.Rating _it : this.ratings) {
                _result[_i++] = _it.getURI();
            }
            return _result;
        }
        if (this.ratingsURI == null) return new String[0];
        return this.ratingsURI;
    }

    private transient Wonder __originalValue;

    static {
        worldwonders.model.repositories.WonderRepository.__setupPersist((aggregates, arg) -> {
            try {
                for (worldwonders.model.Wonder agg : aggregates) {
                    agg.URI = worldwonders.model.converters.WonderConverter.buildURI(arg.getKey(), agg);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }, (aggregates, arg) -> {
            try {
                java.util.List<worldwonders.model.Wonder> oldAggregates = aggregates.getKey();
                java.util.List<worldwonders.model.Wonder> newAggregates = aggregates.getValue();
                for (int i = 0; i < newAggregates.size(); i++) {
                    worldwonders.model.Wonder oldAgg = oldAggregates.get(i);
                    worldwonders.model.Wonder newAgg = newAggregates.get(i);

                    newAgg.URI = worldwonders.model.converters.WonderConverter.buildURI(arg.getKey(), newAgg);
                }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }, aggregates -> {
            for (worldwonders.model.Wonder agg : aggregates) {}
        }, agg -> {
            Wonder _res = agg.__originalValue;
            agg.__originalValue = (Wonder) agg.clone();
            if (_res != null) { return _res; }
            return null;
        });
    }

    public void serialize(final com.dslplatform.json.JsonWriter sw, final boolean minimal) {
        sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_START);
        if (minimal) {
            __serializeJsonObjectMinimal(this, sw, false);
        } else {
            __serializeJsonObjectFull(this, sw, false);
        }
        sw.writeByte(com.dslplatform.json.JsonWriter.OBJECT_END);
    }

    static void __serializeJsonObjectMinimal(
            final Wonder self,
            com.dslplatform.json.JsonWriter sw,
            boolean hasWrittenProperty) {
        sw.writeAscii("\"URI\":");
        com.dslplatform.json.StringConverter.serializeShort(self.URI, sw);

        final java.util.List<String> _tmp_nativeNames_ = self.nativeNames;
        if (_tmp_nativeNames_.size() != 0) {
            sw.writeAscii(",\"nativeNames\":[", 16);
            sw.writeString(_tmp_nativeNames_.get(0));
            for (int i = 1; i < _tmp_nativeNames_.size(); i++) {
                sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
                sw.writeString(_tmp_nativeNames_.get(i));
            }
            sw.writeByte(com.dslplatform.json.JsonWriter.ARRAY_END);
        }

        if (!(self.englishName.length() == 0)) {
            sw.writeAscii(",\"englishName\":", 15);
            sw.writeString(self.englishName);
        }

        if (self.isAncient != false) {
            sw.writeAscii(",\"isAncient\":", 13);
            com.dslplatform.json.BoolConverter.serialize(self.isAncient, sw);
        }

        if (self.imageLink != null) {
            sw.writeAscii(",\"imageLink\":", 13);
            com.dslplatform.json.NetConverter.serialize(self.imageLink, sw);
        }

        final String[] ratingsURI = self.getRatingsURI();
        if (self.ratingsURI != null && ratingsURI.length != 0) {
            sw.writeAscii(",\"ratingsURI\":[");
            com.dslplatform.json.StringConverter.serializeShort(ratingsURI[0], sw);
            for (int i = 1; i < ratingsURI.length; i++) {
                sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
                com.dslplatform.json.StringConverter.serializeShort(ratingsURI[i], sw);
            }
            sw.writeByte(com.dslplatform.json.JsonWriter.ARRAY_END);
        }
    }

    static void __serializeJsonObjectFull(
            final Wonder self,
            com.dslplatform.json.JsonWriter sw,
            boolean hasWrittenProperty) {
        sw.writeAscii("\"URI\":");
        com.dslplatform.json.StringConverter.serializeShort(self.URI, sw);

        final java.util.List<String> _tmp_nativeNames_ = self.nativeNames;
        if (_tmp_nativeNames_.size() != 0) {
            sw.writeAscii(",\"nativeNames\":[", 16);
            sw.writeString(_tmp_nativeNames_.get(0));
            for (int i = 1; i < _tmp_nativeNames_.size(); i++) {
                sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
                sw.writeString(_tmp_nativeNames_.get(i));
            }
            sw.writeByte(com.dslplatform.json.JsonWriter.ARRAY_END);
        } else sw.writeAscii(",\"nativeNames\":[]", 17);

        sw.writeAscii(",\"englishName\":", 15);
        sw.writeString(self.englishName);

        sw.writeAscii(",\"isAncient\":", 13);
        com.dslplatform.json.BoolConverter.serialize(self.isAncient, sw);

        if (self.imageLink != null) {
            sw.writeAscii(",\"imageLink\":", 13);
            com.dslplatform.json.NetConverter.serialize(self.imageLink, sw);
        } else {
            sw.writeAscii(",\"imageLink\":null", 17);
        }

        final String[] ratingsURI = self.getRatingsURI();
        if (ratingsURI != null && ratingsURI.length != 0) {
            sw.writeAscii(",\"ratingsURI\":[");
            com.dslplatform.json.StringConverter.serializeShort(ratingsURI[0], sw);
            for (int i = 1; i < ratingsURI.length; i++) {
                sw.writeByte(com.dslplatform.json.JsonWriter.COMMA);
                com.dslplatform.json.StringConverter.serializeShort(ratingsURI[i], sw);
            }
            sw.writeByte(com.dslplatform.json.JsonWriter.ARRAY_END);
        } else if (ratingsURI != null) {
            sw.writeAscii(",\"ratingsURI\":[]");
        } else {
            sw.writeAscii(",\"ratingsURI\":null");
        }
    }

    public static final com.dslplatform.json.JsonReader.ReadJsonObject<Wonder> JSON_READER = new com.dslplatform.json.JsonReader.ReadJsonObject<Wonder>() {
        @Override
        public Wonder deserialize(final com.dslplatform.json.JsonReader reader) throws java.io.IOException {
            return new worldwonders.model.Wonder(reader);
        }
    };

    private Wonder(final com.dslplatform.json.JsonReader<org.revenj.patterns.ServiceLocator> reader)
            throws java.io.IOException {
        String _URI_ = "";
        this.__locator = java.util.Optional.ofNullable(reader.context);
        java.util.List<String> _nativeNames_ = new java.util.ArrayList<String>(4);
        String _englishName_ = "";
        boolean _isAncient_ = false;
        java.net.URI _imageLink_ = null;
        String[] _ratingsURI_ = _defaultratingsURI;
        byte nextToken = reader.last();
        if (nextToken != '}') {
            int nameHash = reader.fillName();
            nextToken = reader.getNextToken();
            if (nextToken == 'n') {
                if (reader.wasNull()) {
                    nextToken = reader.getNextToken();
                } else {
                    throw new java.io.IOException("Expecting 'u' (as null) at position " + reader.positionInStream()
                            + ". Found " + (char) nextToken);
                }
            } else {
                switch (nameHash) {
                    case 2053729053:
                        _URI_ = reader.readString();
                        nextToken = reader.getNextToken();
                        break;
                    case 535186854:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken != ']') {
                                com.dslplatform.json.StringConverter.deserializeCollection(reader, _nativeNames_);
                            }
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '[' at position " + reader.positionInStream()
                                + ". Found " + (char) nextToken);
                        break;
                    case -1467098976:
                        _englishName_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -171644369:
                        _isAncient_ = com.dslplatform.json.BoolConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case 2025353682:
                        _imageLink_ = com.dslplatform.json.NetConverter.deserializeUri(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case 165103185:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken == ']') {
                                _ratingsURI_ = new String[0];
                            } else {
                                java.util.ArrayList<String> _tmpratingsURI_ = com.dslplatform.json.StringConverter
                                        .deserializeCollection(reader);
                                _ratingsURI_ = _tmpratingsURI_.toArray(new String[_tmpratingsURI_.size()]);
                            }
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '[' at position " + reader.positionInStream()
                                + ". Found " + (char) nextToken);
                        break;
                    default:
                        nextToken = reader.skip();
                        break;
                }
            }
            while (nextToken == ',') {
                nextToken = reader.getNextToken();
                nameHash = reader.fillName();
                nextToken = reader.getNextToken();
                if (nextToken == 'n') {
                    if (reader.wasNull()) {
                        nextToken = reader.getNextToken();
                        continue;
                    } else {
                        throw new java.io.IOException("Expecting 'u' (as null) at position "
                                + reader.positionInStream() + ". Found " + (char) nextToken);
                    }
                }
                switch (nameHash) {
                    case 2053729053:
                        _URI_ = reader.readString();
                        nextToken = reader.getNextToken();
                        break;
                    case 535186854:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken != ']') {
                                com.dslplatform.json.StringConverter.deserializeCollection(reader, _nativeNames_);
                            }
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '[' at position " + reader.positionInStream()
                                + ". Found " + (char) nextToken);
                        break;
                    case -1467098976:
                        _englishName_ = com.dslplatform.json.StringConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case -171644369:
                        _isAncient_ = com.dslplatform.json.BoolConverter.deserialize(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case 2025353682:
                        _imageLink_ = com.dslplatform.json.NetConverter.deserializeUri(reader);
                        nextToken = reader.getNextToken();
                        break;
                    case 165103185:

                        if (nextToken == '[') {
                            nextToken = reader.getNextToken();
                            if (nextToken == ']') {
                                _ratingsURI_ = new String[0];
                            } else {
                                java.util.ArrayList<String> _tmpratingsURI_ = com.dslplatform.json.StringConverter
                                        .deserializeCollection(reader);
                                _ratingsURI_ = _tmpratingsURI_.toArray(new String[_tmpratingsURI_.size()]);
                            }
                            nextToken = reader.getNextToken();
                        } else throw new java.io.IOException("Expecting '[' at position " + reader.positionInStream()
                                + ". Found " + (char) nextToken);
                        break;
                    default:
                        nextToken = reader.skip();
                        break;
                }
            }
            if (nextToken != '}') { throw new java.io.IOException("Expecting '}' at position "
                    + reader.positionInStream() + ". Found " + (char) nextToken); }
        }

        this.URI = _URI_;
        this.nativeNames = _nativeNames_;
        this.englishName = _englishName_;
        this.isAncient = _isAncient_;
        this.imageLink = _imageLink_;
        this.ratingsURI = _ratingsURI_;
    }

    public static Object deserialize(final com.dslplatform.json.JsonReader<org.revenj.patterns.ServiceLocator> reader)
            throws java.io.IOException {
        switch (reader.getNextToken()) {
            case 'n':
                if (reader.wasNull()) return null;
                throw new java.io.IOException("Invalid null value found at: " + reader.positionInStream());
            case '{':
                reader.getNextToken();
                return new worldwonders.model.Wonder(reader);
            case '[':
                return reader.deserializeNullableCollection(JSON_READER);
            default:
                throw new java.io.IOException("Invalid char value found at: " + reader.positionInStream()
                        + ". Expecting null, { or [. Found: " + (char) reader.last());
        }
    }

    public Wonder(
            org.revenj.postgres.PostgresReader reader,
            int context,
            org.revenj.postgres.ObjectConverter.Reader<Wonder>[] readers) throws java.io.IOException {
        this.__locator = reader.getLocator();
        for (org.revenj.postgres.ObjectConverter.Reader<Wonder> rdr : readers) {
            rdr.read(this, reader, context);
        }
        URI = worldwonders.model.converters.WonderConverter.buildURI(reader, this);
        this.__originalValue = (Wonder) this.clone();
    }

    public static void __configureConverter(org.revenj.postgres.ObjectConverter.Reader<Wonder>[] readers, int __index___nativeNames, int __index___englishName, int __index___isAncient, int __index___imageLink, int __index___ratingsURI) {
        readers[__index___nativeNames] = (item, reader, context) -> { { java.util.List<String> __list = org.revenj.postgres.converters.StringConverter.parseCollection(reader, context, false); if(__list != null) {item.nativeNames = __list;} else item.nativeNames = new java.util.ArrayList<String>(4); }; return item; };
        readers[__index___englishName] = (item, reader, context) -> { item.englishName = org.revenj.postgres.converters.StringConverter.parse(reader, context, false); return item; };
        readers[__index___isAncient] = (item, reader, context) -> { item.isAncient = org.revenj.postgres.converters.BoolConverter.parse(reader); return item; };
        readers[__index___imageLink] = (item, reader, context) -> { item.imageLink = org.revenj.postgres.converters.UrlConverter.parse(reader, context); return item; };
        readers[__index___ratingsURI] = (item, reader, context) -> { {
            java.util.List<String> __list = org.revenj.postgres.converters.StringConverter.parseCollection(reader, context, true);
            if (__list != null) item.ratingsURI = __list.toArray(new String[__list.size()]); else item.ratingsURI = new String[0];
        }; return item; };
    }

    public static void __configureConverterExtended(org.revenj.postgres.ObjectConverter.Reader<Wonder>[] readers, int __index__extended_nativeNames, int __index__extended_englishName, int __index__extended_isAncient, int __index__extended_imageLink, int __index__extended_ratingsURI) {
        readers[__index__extended_nativeNames] = (item, reader, context) -> { { java.util.List<String> __list = org.revenj.postgres.converters.StringConverter.parseCollection(reader, context, false); if(__list != null) {item.nativeNames = __list;} else item.nativeNames = new java.util.ArrayList<String>(4); }; return item; };
        readers[__index__extended_englishName] = (item, reader, context) -> { item.englishName = org.revenj.postgres.converters.StringConverter.parse(reader, context, false); return item; };
        readers[__index__extended_isAncient] = (item, reader, context) -> { item.isAncient = org.revenj.postgres.converters.BoolConverter.parse(reader); return item; };
        readers[__index__extended_imageLink] = (item, reader, context) -> { item.imageLink = org.revenj.postgres.converters.UrlConverter.parse(reader, context); return item; };
        readers[__index__extended_ratingsURI] = (item, reader, context) -> { {
            java.util.List<String> __list = org.revenj.postgres.converters.StringConverter.parseCollection(reader, context, true);
            if (__list != null) item.ratingsURI = __list.toArray(new String[__list.size()]); else item.ratingsURI = new String[0];
        }; return item; };
    }
}