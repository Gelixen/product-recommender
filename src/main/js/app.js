import React from 'react';
import ReactDOM from 'react-dom'
import Option from "./option";

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            formValues: {
                age: null,
                student: null,
                income: null
            },
            formOptions: {
                ageOptions: [],
                studentOptions: [],
                incomeOptions: []
            },
            products: []
        };

        this.onChangeHandler = this.onChangeHandler.bind(this);
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/questionnaire/options')
            .then(res => res.json())
            .then(data => {
                this.setState({
                    formOptions: {
                        ageOptions: data.ageOptions,
                        studentOptions: data.studentOptions,
                        incomeOptions: data.incomeOptions
                    },
                    formValues: {
                        age: data.ageOptions[0].name,
                        student: data.studentOptions[0].name,
                        income: data.incomeOptions[0].name
                    }
                }, this.getRecommendations);
            })
            .catch(console.log)
    }

    onChangeHandler(event) {
        const {name, value} = event.target
        this.setState((prevState) => ({formValues: {...prevState.formValues, [name]: value}}), this.getRecommendations)
    }

    getRecommendations() {
        const {age, student, income} = this.state.formValues;
        const query = `?age=${age}&student=${student}&income=${income}`;

        fetch('http://localhost:8080/api/recommendations' + query)
            .then(res => res.json())
            .then(data => {
                this.setState({products: data.products});
            })
            .catch(console.log)
    }

    render() {
        return (
            <div>
                <div>
                    <form>
                        <Option id="age"
                                question="What's your age?"
                                options={this.state.formOptions.ageOptions}
                                onChangeHandler={this.onChangeHandler}/>
                        <Option id="student"
                                question="Are you a student?"
                                options={this.state.formOptions.studentOptions}
                                onChangeHandler={this.onChangeHandler}/>
                        <Option id="income"
                                question="What's your yearly income?"
                                options={this.state.formOptions.incomeOptions}
                                onChangeHandler={this.onChangeHandler}/>
                        <hr/>
                    </form>
                </div>
                <div>
                    {this.state.products.map(product => (
                        <option key={product.name} value={product.name}>
                            {product.name}
                        </option>
                    ))}
                </div>
            </div>
        )
    }
}

ReactDOM.render(
    <App/>,
    document.getElementById('app')
)