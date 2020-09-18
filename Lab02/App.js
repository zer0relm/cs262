import { StatusBar } from 'expo-status-bar';
import React, { useState } from 'react';
import { StyleSheet, Text, TextInput, View, Button, FlatList } from 'react-native';

export default function App() {
  const [name, setName] = useState('');
  const [age, setAge] = useState(1);
  const [birthday, setBirthday] = useState([]);
  
  const pressHandler = () => {
    var newAge;
    newAge = age + 1;
    setAge(newAge);
    setBirthday(birthday.concat({key: newAge.toString()}))
    
  }

  
  return (
    <View style={styles.container}>
      <Text>Enter your Name:</Text>
      <TextInput 
      style={styles.input}
      placeholder='Your Name'
      onChangeText={(val) => setName(val)}/>

      <Text>{name} is {age} years old</Text>

      <Button
      style={styles.input}
      title="Birthday"
      onPress={pressHandler}
      />

      <FlatList
        data={birthday}
        renderItem={({ item }) => (
          <Text>{item.key}</Text>
        )}
      />

      <StatusBar style="auto" />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
    paddingTop: 50,
  },
  input: { 
      borderColor: 'gray', 
    borderWidth: 1, 
    height: 40, 
    width: 150, 
    margin: 10,
    padding: 10,
  },
  button: {
    borderWidth: 1,
  }
  
});
