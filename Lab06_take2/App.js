import { StatusBar } from 'expo-status-bar';
import React, {useEffect, useState} from 'react';
import { ActivityIndicator, FlatList, StyleSheet, Text, View } from 'react-native';

export default function App() {
  
  const [isLoading, setLoading] = useState(true);
  const [data, setData] = useState([]);

  useEffect(() => {
    fetch('https://www.googleapis.com/books/v1/volumes?q=Ender%27s%20quartet')
      .then((response) => response.json())
      .then((json) => setData(json.items))
  }, []);

  // useEffect(() => {
  //   fetch('https://reactnative.dev/movies.json')
  //     .then((response) => response.json())
  //     .then((json) => setData(json.movies))
  //     .catch((error) => console.error(error))
  //     .finally(() => setLoading(false));
  // }, []);
  
  return (
    <View style={{ flex: 1, padding: 24 }}>
      {isLoading ? <ActivityIndicator/> : (
        <FlatList
          data={data}
          keyExtractor={({ id }, index) => id}
          renderItem={({ item }) => (
            <Text>{item.volumeInfo.title}</Text>
          )}
        />
      )}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
