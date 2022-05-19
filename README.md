### Hexlet tests and linter status:
[![Actions Status](https://github.com/nikisysoev/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/nikisysoev/java-project-lvl3/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/f490fadd257131f6c4d6/maintainability)](https://codeclimate.com/github/nikisysoev/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/f490fadd257131f6c4d6/test_coverage)](https://codeclimate.com/github/nikisysoev/java-project-lvl3/test_coverage)
![example workflow](https://github.com/nikisysoev/java-project-lvl3/actions/workflows/main.yml/badge.svg)

# DataValidator

Data Validator is a library with which you can check the correctness of data. Chain together methods to build a schema.
You can add as many validations as you want, they will complement each other. Pass the validation value to 'isvalid' 
method to check it.

## Getting Started

### String validation 

Provides 'required', 'contains' and 'minLength' validations.

```ts
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();
StringSchema schema = v.string(); 

// a null and any string value will return true, other values will return false
schema.isValid(""); // true
schema.isValid(null); // true

// any non-empty string value
schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid("");; // false

// string contains a specific substring
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false, because another validation 'contains("whatthe") has been added

schema = v.string(); 

// string length is greater or equal to the specified number
schema.minLength(FIVE).isValid("what does the fox say"); // true
schema.minLength(FIVE).isValid("what"); // false
```

### Number validation

Provides 'required', 'positive' and 'range' validations.

```ts
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

Validator v = new Validator();
NumberSchema schema = v.number();

schema.isValid(null); // true

// any number including zero
schema.required();

schema.isValid(null); // false
schema.isValid(10) // true
schema.isValid("5"); // false

// positive number
schema.positive().isValid(10); // true
schema.isValid(-10); // false

// range is inclusive
schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```

### Map validation

Provides 'required' and 'size' validations.

```ts
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

Validator v = new Validator();
MapSchema schema = v.map();

schema.isValid(null); // true

// values with Map type are required
schema.required();

schema.isValid(null) // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

// number of pairs key-value 
schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```

### Nested validation

Validation complex nested data may require validating not only the map object, but also the nested data.

```ts
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.BaseSchema;

Validator v = new Validator();
MapSchema schema = v.map();

// shape - allows you to validate Map values 
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null); // true, because only 'positive' without 'required'
schema.isValid(human2);

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false

Map<String, Object> human4 = new HashMap<>();
human4.put("name", "Valya");
human4.put("age", -5);
schema.isValid(human4); // false
```
