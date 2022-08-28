import json

def lambda_handler(event, context):
    print('Dyu was here')

    return {
        'statusCode': 200,
        'body': json.dumps('Hello elephant!')
    }
